package 贪心;

import java.util.TreeSet;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/3 00:50 03
 * @since 1.0
 **/
public class No1414 {

    /**
     * 和为 K 的最少斐波那契数字数目
     *
     * @param k
     * @return
     */
    public int findMinFibonacciNumbers(int k) {
        TreeSet<Integer> vis = new TreeSet<>();
        vis.add(1);
        int head = 1;
        int second = 1;
        int curr = -1;
        while (k > curr) {
            curr = head + second;
            head = second;
            second = curr;
            vis.add(curr);
        }
        return find(vis, k);
    }

    public int find(TreeSet<Integer> vis, int k) {
        int ans = 0;
        while (k > 0) {
            Integer v = vis.floor(k);
            k -= v;
            ans++;
        }
        return ans;
    }


}
