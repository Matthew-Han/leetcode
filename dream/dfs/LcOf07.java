package dfs;

import java.util.*;

/**
 * @ClassName LcOf07
 * @Description LCP #07 传递信息
 * @Author MatthewHan
 * @Date 2020/9/3 11:18
 * @Version 1.0
 **/
public class LcOf07 {
    int count = 0;

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 19.14% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 9.38% 的用户
     *
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays(int n, int[][] relation, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        dfs(relation, list, k, n);
        return count;
    }

    public void dfs(int[][] relation, LinkedList<Integer> list, int k, int n) {
        int curr = list.peekLast();
        if (list.size() - 1 == k) {
            if (curr == n - 1) {
                count++;
            }
            return;
        }
        for (int[] ints : relation) {
            if (ints[0] == curr) {
                LinkedList<Integer> newList = new LinkedList<>(list);
                newList.add(ints[1]);
                dfs(relation, newList, k, n);
            }
        }

    }

    public static void main(String[] args) {
        LcOf07 lcOf07 = new LcOf07();
        System.out.println(lcOf07.numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
    }
}
