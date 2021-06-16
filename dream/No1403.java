import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MinimumSubsequenceInNonIncreasingOrder
 * @Description #1403 非递增顺序的最小子序列
 * @Author MatthewHan
 * @Date 2020/7/13 17:05
 * @Version 1.0
 **/
public class No1403 {

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 93.69% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int curr = 0;
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {

            list.add(nums[i]);
            curr += nums[i];
            sum -= nums[i];
            if (curr > sum) {
                return list;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(minSubsequence(new int[]{4, 4, 7, 6, 7}));
    }
}
