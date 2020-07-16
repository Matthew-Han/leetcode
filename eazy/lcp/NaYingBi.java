package lcp;

/**
 * @ClassName NaYingBi
 * @Description #LCP 06 拿硬币
 * @Author MatthewHan
 * @Date 2020/7/16 10:22
 * @Version 1.0
 **/
public class NaYingBi {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param coins
     * @return
     */
    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            count += coin / 2 + coin % 2;
        }
        return count;
    }
}
