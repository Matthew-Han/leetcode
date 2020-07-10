package 桶排序;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName 桶排序.HowManyNumbersAreSmallerThanTheCurrentNumber
 * @Description #1365 有多少小于当前数字的数字
 * @Author MatthewHan
 * @Date 2020/7/11 02:59
 * @Version 1.0
 **/
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    /**
     * 老K桶了
     * （双for循环用时）
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 82.19% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 100.00% 的用户
     * <p>
     * （空间换时间优化后，如下最新的代码）
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int[] smallerNumbersThanCurrentByBucket(int[] nums) {
        int[] bucket = new int[101];

        for (int num : nums) {
            bucket[num]++;
        }
        // 对k桶做累加
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] != 0 ? bucket[nums[i] - 1] : 0;
        }
        return nums;
    }


    /**
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 60.79% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, nums.length);
        int[][] temp = new int[nums.length][2];
        Arrays.sort(nums);
        temp[0][0] = nums[0];
        temp[0][1] = 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            temp[i][0] = nums[i];
            if (temp[i][0] != temp[i - 1][0]) {
                index = i;
            }
            temp[i][1] = index;

        }
        Arrays.sort(temp, Comparator.comparingInt(o -> o[0]));
        System.out.println("temp = " + Arrays.deepToString(temp));
        for (int i = 0; i < result.length; i++) {
            for (int[] ints : temp) {
                if (result[i] == ints[0]) {
                    result[i] = ints[1];
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrentByBucket(new int[]{1, 2, 6, 7, 0, 0, 9})));
    }

}
