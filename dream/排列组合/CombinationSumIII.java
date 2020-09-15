package 排列组合;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CombinationSumIII
 * @Description #216 组合总和 III
 * @Author MatthewHan
 * @Date 2020/9/11 02:27
 * @Version 1.0
 **/
public class CombinationSumIII {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 69.98% 的用户
     * 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 54.87% 的用户
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        // 数组的元素从1 ~ 9
        int limit = Math.min(n, 9);
        for (int i = 1; i <= limit; i++) {
            List<Integer> tmp = new ArrayList<>(k);
            tmp.add(i);
            tmp.add(i);
            dfs(k, n, limit, tmp, res);
        }
        return res;
    }

    public static void dfs(int k, int n, int limit, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == k + 1) {
            if (tmp.get(0) == n) {
                tmp.remove(0);
                res.add(tmp);
            }
            return;
        }
        int start = tmp.get(tmp.size() - 1);
        for (int i = start + 1; i <= limit; i++) {
            List<Integer> next = new ArrayList<>(tmp);
            int curr = next.get(0) + i;
            if (curr < n) {
                next.set(0, curr);
                next.add(i);
                dfs(k, n, limit, next, res);
                // 这里是k，因为还妹加那个值
            } else if ((curr == n) && next.size() == k) {
                next.remove(0);
                next.add(i);
                res.add(next);
            }

        }


    }

}

