package 进制系列;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/25 17:24
 **/
public class TotalHammingDistance {

    /**
     * #477 汉明距离总和
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 15.05% 的用户
     *
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            for (int num : nums) {
                // 这个 x 就是该字符串在第 i 位上的二进制数
                int x = num >> i;
                // 判断下这个 x 是否为 0,可以用 & 运算,任何二进制位和 1 做 & 运算都是本身
                one += x & 1;
            }
            // 1 的个数和 0 的个数相乘
            ans += one * (nums.length - one);
        }
        return ans;
    }


}
