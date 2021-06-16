/**
 * @ClassName FindNumbersWithEvenNumberOfDigits
 * @Description #1295 统计位数为偶数的数字
 * @Author MatthewHan
 * @Date 2020/7/9 17:49
 * @Version 1.0
 **/
public class No1295 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.86% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 5.88% 的用户
     *
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (9 < num && num < 100 || 999 < num && num < 10000 || num == 100000) {
                count++;
            }
        }
        return count;
    }

}
