package 双指针;

/**
 * @author MatthewHan
 * @version 1.0
 * @description
 * @date 2020/10/1 21:18
 **/
public class SortColors {

    /**
     * #75 颜色分类
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 11.46% 的用户
     */
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            }
        }
        swap(nums, 0, count0, 0);
        swap(nums, count0, count0 + count1, 1);
    }

    public void swap(int[] nums, int start, int countSum, int color) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == color && i >= countSum) {
                for (int j = start; j < countSum; j++) {
                    if (nums[j] != color) {
                        nums[j] = nums[i] ^ nums[j];
                        nums[i] = nums[i] ^ nums[j];
                        nums[j] = nums[i] ^ nums[j];
                        break;
                    }
                }
            }
        }
    }
}
