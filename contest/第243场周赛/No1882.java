package 第243场周赛;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/30 23:36
 * @description
 * @since 1.0.0
 **/
public class No1882 {

    /**
     * #1882 使用服务器处理任务
     * <p>
     * 模拟法需要注意的三个地方吧:
     * 0. 注意存在某个时刻会出现多个任务可被执行;
     * 1. 防止 TLE ：直接跳转到运行队列中的最先空闲下来的服务器时间节点;
     * 2. 防止 TLE ：两个优先队列处理（运行态和就绪态）;
     * <p>
     * 执行用时： 444 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 67.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param servers
     * @param tasks
     * @return
     */
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] ans = new int[tasks.length];
        // 运行中的服务器, 之前这里是 Queue, 没有及时 break, 所以拉了
        // int[]: 长度为 2, 第 1 位是 serverId, 第 2 位是当前时间 + task 需要执行的时长
        PriorityQueue<int[]> runtimeServerQueue = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        // 等待被分配的服务器
        // int[]: 长度为 2, 第 1 位是 serverId, 第 2 位是服务器权重
        PriorityQueue<int[]> pendingServerQueue = new PriorityQueue<>((o1, o2) -> {
            // 先判权重升序, 权重一样, 则按照下标升序
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        // 先将所有的服务器塞到等待队列中
        for (int i = 0; i < servers.length; i++) {
            pendingServerQueue.offer(new int[]{i, servers[i]});
        }
        // 每秒需要被执行的任务
        Queue<Integer> taskQueue = new LinkedList<>();
        for (int t : tasks) {
            taskQueue.offer(t);
        }
        int sec = 0;
        int trueSec = 0;
        while (!taskQueue.isEmpty()) {
            int b = 0x3f3f3f3f;
            // step0. 先处理在运行的 serverQueue
            int limit = runtimeServerQueue.size();
            for (int i = 0; i < limit; i++) {
                int[] task = runtimeServerQueue.poll();
                // 根据当前和当前储存的预期完成时间比较, 一致则说明任务完成
                if (task[1] == trueSec) {
                    // 加入到等待队列
                    pendingServerQueue.offer(new int[]{task[0], servers[task[0]]});
                } else {
                    // b: 运行中的服务器中最先会空闲的预期时间
                    b = Math.min(b, task[1]);
                    runtimeServerQueue.offer(task);
                    // 因为是优先队列, 一旦 else 了, Queue 后面服务器都不可能是这个时间节点完成
                    // 所以这里可以 break, 不然会 TLE
                    break;
                }
            }
            // step1. 选择 空闲 / 权重最小 / 下标最小 的服务器
            // 存在空闲服务器
            if (!pendingServerQueue.isEmpty()) {
                // 因为可能轮转了很多轮, 所以 taskQueue 里面的很多任务都可以在当前时间执行了(可能会有多个任务可执行)
                while (sec < trueSec && !taskQueue.isEmpty() && !pendingServerQueue.isEmpty()) {
                    int task = taskQueue.poll();
                    int[] runnableServer = pendingServerQueue.poll();
                    ans[sec++] = runnableServer[0];
                    // 将 空闲的服务器 加入到 运行的服务器队列 中
                    runtimeServerQueue.offer(new int[]{runnableServer[0], trueSec + task});
                }
                trueSec++;
            } else {
                // 防止 TLE 关键, 跳转到 runtime 服务器最先空闲的时间节点
                trueSec = b;
            }
        }
        return ans;
    }

}
