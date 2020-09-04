import java.util.Arrays;

/**
 * @ClassName MaximumNumberOfCoinsYouCanGet
 * @Description #1561 你可以获得的最大硬币数目
 * @Author MatthewHan
 * @Date 2020/9/4 17:32
 * @Version 1.0
 **/
public class MaximumNumberOfCoinsYouCanGet {

    /**
     * 执行用时： 32 ms , 在所有 Java 提交中击败了 45.30% 的用户
     * 内存消耗： 49.3 MB , 在所有 Java 提交中击败了 53.06% 的用户
     *
     * @param piles
     * @return
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int count = 0;
        for (int i = piles.length - 1; i >= 0; i -= 2) {
            count++;
            ans += piles[i - 1];
            if (count == piles.length / 3) {
                return ans;
            }
        }
        return ans;
    }
}
