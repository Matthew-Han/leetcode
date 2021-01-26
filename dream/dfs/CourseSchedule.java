package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/14 17:19
 **/
public class CourseSchedule {


    /**
     * 拓扑排序
     * 执行用时： 143 ms , 在所有 Java 提交中击败了 5.00% 的用户
     * 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 52.11% 的用户
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] p : prerequisites) {
            queue.offer(p);
        }

        while (!search(numCourses, queue).isEmpty()) {
            Queue<Integer> tmp = search(numCourses, queue);
            while (!tmp.isEmpty()) {
                Integer t = tmp.poll();
                queue.removeIf(ints -> ints[0] == t || ints[1] == t);
            }
        }
        return queue.isEmpty();
    }

    public Queue<Integer> search(int numCourses, Queue<int[]> queue) {
        Queue<Integer> res = new LinkedList<>();
        int[] set = new int[numCourses];
        for (int[] q : queue) {
            if (set[q[1]] == 0) {
                set[q[1]] = 1;
            }
        }
        for (int[] q : queue) {
            if (set[q[0]] != 0) {
                set[q[0]] = 0;
            }
        }
        for (int i = 0; i < set.length; i++) {
            if (set[i] == 1) {
                res.offer(i);
            }
        }
        return res;
    }


    /**
     * #207 课程表
     * 经典超时
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return prerequisites.length == 0;
        }
        boolean[] vis = new boolean[prerequisites.length];
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        for (int[] p : prerequisites) {
            if (!queue.contains(p[1])) {
                queue.offer(p[1]);
            }
        }
        for (int[] p : prerequisites) {
            queue.remove(p[0]);
        }
        while (!queue.isEmpty()) {
            check(prerequisites, queue, vis);
            queue = makeQueue(prerequisites, vis);
            // System.out.println("q: " + queue);
        }
        for (boolean b : vis) {
            ans += b ? 1 : 0;
        }
        return prerequisites.length == ans;
    }

    public void check(int[][] prerequisites, Queue<Integer> queue, boolean[] vis) {
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (!vis[i] && prerequisites[i][1] == x) {
                    vis[i] = true;
                }
            }
        }
    }

    public Queue<Integer> makeQueue(int[][] prerequisites, boolean[] vis) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!vis[i] && !queue.contains(prerequisites[i][1])) {
                queue.offer(prerequisites[i][1]);
            }
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (!vis[i]) {
                queue.remove(prerequisites[i][0]);
            }
        }
        return queue;
    }
}
