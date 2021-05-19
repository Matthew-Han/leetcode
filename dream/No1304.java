/**
 * @ClassName FindNuniqueIntegersSumUpToZero
 * @Description #1304 和为零的N个唯一整数
 * @Author MatthewHan
 * @Date 2020/7/10 10:41
 * @Version 1.0
 **/
public class No1304 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 6.67% 的用户
     *
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[]{0};
        }
        int[] result = new int[n];
        int left = n / 2 - 1;
        int leftNum = -1;
        int rightNum = 1;
        int right = n / 2;
        if ((n & 1) != 0) {
            result[n / 2] = 0;
            right = n / 2 + 1;
        }
        while (left >= 0) {
            result[left--] = leftNum;
            leftNum--;
            result[right++] = rightNum;
            rightNum++;
        }
        return result;
    }

}
