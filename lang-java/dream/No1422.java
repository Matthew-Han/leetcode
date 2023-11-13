/**
 * @ClassName MaximumScoreAfterSplittingAstring
 * @Description #1422 分割字符串的最大得分
 * @Author MatthewHan
 * @Date 2020/7/14 14:59
 * @Version 1.0
 **/
public class No1422 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 62.06% 的用户
     * 内存消耗： 37.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public static int maxScore(String s) {
        int max1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                max1++;
            }
        }
        int curr;
        int curr0 = 0;
        int curr1 = 0;
        int result = Integer.MIN_VALUE;
        /*
         * 最后一位不算，因为是0，不能用，
         * 是1，已经加到了max1里了
         */
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                curr0++;
            } else {
                curr1++;
            }
            curr = curr0 + max1 - curr1;
            System.out.println("curr = " + curr);
            result = Math.max(result, curr);

        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(maxScore("0001"));
    }
}
