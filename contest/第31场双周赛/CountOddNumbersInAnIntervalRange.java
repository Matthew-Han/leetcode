package 第31场双周赛;

/**
 * @ClassName CountOddNumbersInAnIntervalRange
 * @Description #1523 在区间范围内统计奇数数目
 * @Author MatthewHan
 * @Date 2020/7/25 20:25
 * @Version 1.0
 **/
public class CountOddNumbersInAnIntervalRange {

    /**
     * #1
     * Easy
     * <p>
     * 想象成种树，[2, 5]区间只能种1颗「奇数3」；[1, 6]区间只能种2颗「奇数3，5」
     * 只有low和high都为偶数的时候不需要+1
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param low
     * @param high
     * @return
     */
    public int countOddsByMath(int low, int high) {
        return (high + 1) / 2 - (low) / 2;
    }

    /**
     * 老暴力了
     * 执行用时： 1813 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param low
     * @param high
     * @return
     */
    public int countOdds(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if ((i & 1) != 0) {
                count++;
            }
        }
        return count;
    }

}
