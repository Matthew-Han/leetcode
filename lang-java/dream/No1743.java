import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/26 09:50
 * @since 1.0
 **/
public class No1743 {

    /**
     * 从相邻元素对还原数组
     *
     * @param adjacentPairs
     * @return
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> indexs = new HashMap<>();
        Set<Integer> vis = new HashSet<>();
        for (int[] adjacentPair : adjacentPairs) {
            indexs.put(adjacentPair[0], indexs.getOrDefault(adjacentPair[0], new ArrayList<>()));
            indexs.get(adjacentPair[0]).add(adjacentPair[1]);
            indexs.put(adjacentPair[1], indexs.getOrDefault(adjacentPair[1], new ArrayList<>()));
            indexs.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        Deque<Integer> dq = new LinkedList<>();
        vis.add(adjacentPairs[0][0]);
        vis.add(adjacentPairs[0][1]);
        dq.offer(adjacentPairs[0][0]);
        dq.offer(adjacentPairs[0][1]);
        dfs(indexs, adjacentPairs[0][0], vis, dq, true);
        dfs(indexs, adjacentPairs[0][1], vis, dq, false);


        int[] ans = new int[dq.size()];
        int index = 0;
        while (!dq.isEmpty()) {
            ans[index++] = dq.poll();
        }
        return ans;


    }

    public void dfs(Map<Integer, List<Integer>> indexs, int curr, Set<Integer> vis, Deque<Integer> tmp, boolean toward) {
        List<Integer> list = indexs.get(curr);
        if (list == null) {
            return;
        }
        // left
        if (toward) {
            for (Integer n : list) {
                if (!vis.contains(n)) {
                    tmp.offerFirst(n);
                    vis.add(n);
                    dfs(indexs, n, vis, tmp, toward);
                }
            }

        } else {
            for (Integer n : list) {
                if (!vis.contains(n)) {
                    tmp.offerLast(n);
                    vis.add(n);
                    dfs(indexs, n, vis, tmp, toward);
                }
            }
        }

    }
}
