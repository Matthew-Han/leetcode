package 二分查找;

/**
 * @ClassName FindPeakElement
 * @Description #162 寻找峰值
 * @Author MatthewHan
 * @Date 2020/9/4 09:44
 * @Version 1.0
 **/
public class No162 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 47.49% 的用户
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 < 0) {
                if (mid + 1 < nums.length) {
                    return nums[mid] > nums[mid + 1] ? mid : mid + 1;
                } else {
                    return mid;
                }
            } else if (mid + 1 >= nums.length) {
                return nums[mid] > nums[mid - 1] ? mid : mid - 1;
            } else if (mid + 1 < nums.length && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid + 1 < nums.length && nums[mid - 1] > nums[mid + 1] && nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else if (mid + 1 < nums.length && nums[mid - 1] < nums[mid + 1] && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else if (mid + 1 < nums.length && nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
                // right = mid - 1;
            }
        }
        return -1;
    }


}
