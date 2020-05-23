import java.util.Arrays;

/**
 * @ClassName NonDecreasingArray
 * @Description #665 非递减数列
 * @Author MatthewHan
 * @Date 2020/5/23 21:03
 * @Version 1.0
 **/
public class NonDecreasingArray {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.89% 的用户
     * 内存消耗 : 40.9 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 3) {
            return true;
        }
        int num = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                num++;
                if (i > 0 && i < nums.length - 2 && nums[i - 1] > nums[i + 1] && nums[i] > nums[i + 2]) {
                    return false;
                }
            }
        }
        return num <= 1;
    }


    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{1, 5, 4, 6, 7, 10, 8, 9}));
    }
}
