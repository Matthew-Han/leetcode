import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MissingNumber
 * @Description #268 缺失数字
 * @Author MatthewHan
 * @Date 2020/5/6 17:28
 * @Version 1.0
 **/
public class MissingNumber {

    /**
     * 官方题解，测试用例有问题
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 27.59% 的用户
     * 内存消耗 : 40.9 MB , 在所有 Java 提交中击败了 6.67% 的用户
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        // 判断 n 是否出现在末位
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // 判断 0 是否出现在首位
        else if (nums[0] != 0) {
            return 0;
        }
        // 此时缺失的数字一定在 (0, n) 中
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        // 未缺失任何数字（保证函数有返回值）
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1}));
    }
}
