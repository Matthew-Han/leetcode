package xyz.yuanmo;

import java.util.Arrays;

/**
 * @ClassName BestTimeToBuyAndSellStock
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

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1}));
    }
}
