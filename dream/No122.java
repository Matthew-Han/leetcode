/**
 * @ClassName BestTimeToBuyAndSellStockII
 * @Description #122 买卖股票的最佳时机 II
 * @Author MatthewHan
 * @Date 2020/4/20 10:04
 * @Version 1.0
 **/
public class No122 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.10% 的用户
     * 内存消耗 : 39.6 MB , 在所有 Java 提交中击败了 6.25% 的用户
     * @param prices
     * @return
     */
    public static int violence(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int maxDv = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0) {
                maxDv += prices[i + 1] - prices[i];
            }
        }
        return maxDv;
    }

    public static void main(String[] args) {
        System.out.println(violence(new int[]{2,2,5}));
    }
}
