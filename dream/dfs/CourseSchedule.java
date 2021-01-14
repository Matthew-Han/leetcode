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
