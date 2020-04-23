package leetcode.eazy;

import java.util.Arrays;

/**
 * @ClassName leetcode.eazy.BestTimeToBuyAndSellStock
 * @Description #121 买卖股票的最佳时机
 * @Author MatthewHan
 * @Date 2020/4/18 02:20
 * @Version 1.0
 **/
public class BestTimeToBuyAndSellStock {

    /**
     * 执行用时 : 370 ms , 在所有 Java 提交中击败了 9.26% 的用户
     * 内存消耗 : 39.4 MB , 在所有 Java 提交中击败了 5.32% 的用户
     * 老暴力了。。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        int nextFucker = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int f = i - 1 ; f >= 0; f--) {
                int fucker = prices[i] - prices[f];
                if (fucker > nextFucker) {
                    nextFucker = fucker;
                }
            }
        }
        return nextFucker;

    }

    /**
     * 改良版
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.06% 的用户
     * 内存消耗 : 39.4 MB , 在所有 Java 提交中击败了 5.32% 的用户
     * 一次循环，指针i随下标移动，每移动一次，找出前i天的最小值，return第i天的价格 - 最小值即可。
     * @param prices
     * @return
     */
    public static int dp(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int maxDv = 0;
        int minPrice = prices[0];
        for (int k = 1; k < prices.length; k++) {
            
            if (minPrice > prices[k]) {
                minPrice = prices[k];
            }
            if (prices[k] - minPrice > maxDv) {
                maxDv = prices[k] - minPrice;
            }
        }
        return maxDv;
    }

    public static void main(String[] args) {
        System.out.println(dp(new int[]{6,19,7,9,6,22}));
    }
}
