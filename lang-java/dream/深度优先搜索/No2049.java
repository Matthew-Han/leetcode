package 深度优先搜索;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/14 12:54 14
 * @since 1.0
 **/
public class No2049 {


    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, List<Integer>> tree = new HashMap<>();
    Map<Integer, Integer> father = new HashMap<>();
    TreeMap<Long, Integer> finals = new TreeMap<>((o1, o2) -> Long.compare(o2, o1));

    /**
     * 统计最高分的节点数目
     *
     * @param parents
     * @return
     */
    public int countHighestScoreNodes(int[] parents) {
        for (int i = 1; i < parents.length; i++) {
            List<Integer> v = tree.getOrDefault(parents[i], new ArrayList<>());
            v.add(i);
            tree.put(parents[i], v);
        }
        dfs(tree, 0);
        for (int i = 0; i < parents.length; i++) {
            int size = parents.length - 1;
            long t = 1;
            List<Integer> list = tree.get(i);
            if (list != null) {
                for (int j : list) {
                    t *= map.get(j);
                    size -= map.get(j);
                }
            }
            Integer var1 = father.get(i);
            t *= (size == 0 ? 1 : size);
            finals.put(t, finals.getOrDefault(t, 0) + 1);
        }
        for (Map.Entry<Long, Integer> e : finals.entrySet()) {
            return e.getValue();
        }
        return -1;
    }

    public int dfs(Map<Integer, List<Integer>> tree, int curr) {
        List<Integer> list = tree.get(curr);
        if (list == null) {
            map.put(curr, 1);
            return 1;
        }
        int c = 0;
        for (int l : list) {
            c += dfs(tree, l);
            father.put(l, curr);
        }
        map.put(curr, c + 1);
        return c + 1;
    }

}
