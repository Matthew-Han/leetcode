/**
 * @ClassName FinalPricesWithAspecialDiscountInAshop
 * @Description #1475 商品折扣后的最终价格
 * @Author MatthewHan
 * @Date 2020/7/15 11:16
 * @Version 1.0
 **/
public class FinalPricesWithAspecialDiscountInAshop {


    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param prices
     * @return
     */
    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public static void main(String[] args) {

    }
}
