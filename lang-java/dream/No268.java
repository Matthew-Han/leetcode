import java.util.Arrays;

/**
 * @ClassName MissingNumber
 * @Description #268 缺失数字
 * @Author MatthewHan
 * @Date 2020/5/6 17:28
 * @Version 1.0
 **/
public class No268 {

    /**
     * 官方题解，测试用例有问题
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 27.59% 的用户
     * 内存消耗 : 40.9 MB , 在所有 Java 提交中击败了 6.67% 的用户
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        // 判断 n 是否出现在末位
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        // 判断 0 是否出现在首位
        else if (nums[0] != 0) {
            return 0;
        }
        // 此时缺失的数字一定在 (0, n) 中
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i - 1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        // 未缺失任何数字（保证函数有返回值）
        return -1;
    }

    /**
     * 2021.11.08
     *
     * @param nums
     * @return
     */
    public int date20211108(int[] nums) {
        int len = nums.length;
        int min = 0;
        int sum = (min + len) * (len + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

}
