package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName JumpGameIII
 * @Description #1306 跳跃游戏 III
 * @Author MatthewHan
 * @Date 2020/8/3 18:12
 * @Version 1.0
 **/
public class JumpGameIII {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 45.35% 的用户
     * 内存消耗： 47.6 MB , 在所有 Java 提交中击败了 26.92% 的用户
     *
     * @param arr
     * @param start
     * @return
     */
    public static boolean canReach(int[] arr, int start) {
        // 访问标记
        boolean[] visited = new boolean[arr.length];
        int len = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        int left = start - arr[start];
        int right = start + arr[start];
        if (left >= 0 && left < len) {
            queue.offer(left);
        }
        if (right >= 0 && right < len) {
            queue.offer(right);
        }
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                int tmpIndex = queue.poll();
                if (arr[tmpIndex] == 0) {
                    return true;
                }
                left = tmpIndex - arr[tmpIndex];
                right = tmpIndex + arr[tmpIndex];
                if (left >= 0 && left < len && !visited[left]) {
                    queue.offer(left);
                    visited[left] = true;
                }
                if (right >= 0 && right < len && !visited[right]) {
                    queue.offer(right);
                    visited[right] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }


}
