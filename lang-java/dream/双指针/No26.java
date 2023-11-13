package 双指针;

import java.util.Arrays;

/**
 * @ClassName RemoveDuplicatesFromSortedArray
 * @Description #26 删除排序数组中的重复项
 * @Author MatthewHan
 * @Date 2020/8/7 18:04
 * @Version 1.0
 **/
public class No26 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.40% 的用户
     * 内存消耗： 41.8 MB , 在所有 Java 提交中击败了 15.10% 的用户
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int len = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i++;
                j++;
                len++;
            }
        }
        System.out.println("nums = " + Arrays.toString(nums));
        return len;


    }

}
