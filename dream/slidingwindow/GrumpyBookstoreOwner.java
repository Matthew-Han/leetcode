package slidingwindow;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/23 14:25
 **/
public class GrumpyBookstoreOwner {

    /**
     * #1052 爱生气的书店老板
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 79.44% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 5.11% 的用户
     *
     * @param customers
     * @param grumpy
     * @param x
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < customers.length; i++) {
            sum += i < x ? customers[i] : (grumpy[i] == 0 ? customers[i] : 0);
        }
        ans = sum;
        int index = x;
        while (index < customers.length) {
            sum -= grumpy[index - x] == 1 ? customers[index - x] : 0;
            sum += grumpy[index] == 1 ? customers[index] : 0;
            ans = Math.max(ans, sum);
            index++;
        }
        return ans;
    }
}
