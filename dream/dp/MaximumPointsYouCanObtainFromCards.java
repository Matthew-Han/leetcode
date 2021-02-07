package dp;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/7 15:08
 **/
public class MaximumPointsYouCanObtainFromCards {

    /**
     * #1423 可获得的最大点数
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 20.23% 的用户
     * 内存消耗： 47.7 MB , 在所有 Java 提交中击败了 57.61% 的用户
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int tmp = sumOfTheBitch(cardPoints, k);
        int ans = tmp;
        for (int i = 0; i < k; i++) {
            tmp -= cardPoints[cardPoints.length - k + i];
            tmp += cardPoints[i];
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    public int sumOfTheBitch(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int sum = 0;
        for (int i = len - 1; i >= len - k; i--) {
            sum += cardPoints[i];
        }
        return sum;
    }
}
