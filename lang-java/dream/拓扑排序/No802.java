package 拓扑排序;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/5 09:45
 * @since 1.0
 **/
public class No802 {

    /**
     * 找到最终安全的状态
     *
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> safe = new TreeSet<>();
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == null || graph[i].length == 0) {
                safe.add(i);
                vis[i] = true;
            }
        }
        // System.out.println(safe);
        int prev = 0;
        while (prev != safe.size()) {
            prev = safe.size();
            for (int i = 0; i < graph.length; i++) {
                if (!vis[i] && graph[i] != null && graph[i].length > 0) {
                    int cnt = 0;
                    for (int sub : graph[i]) {
                        cnt += safe.contains(sub) ? 1 : 0;
                    }
                    if (cnt == graph[i].length) {
                        safe.add(i);
                        vis[i] = true;
                    }
                }
            }
        }
        return new ArrayList<>(safe);
    }
}