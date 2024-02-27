package 二分查找;

/**
 * @ClassName SingleElementInaSortedArray
 * @Description #540 有序数组中的单一元素
 * @Author MatthewHan
 * @Date 2020/7/3 09:36
 * @Version 1.0
 **/
public class No540 {


    public int date20220214(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (mid == 0 || mid == nums.length - 1) {
                return nums[mid];
            } else if (nums[mid - 1] == nums[mid]) {
                if (mid % 2 == 0) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid + 1] == nums[mid]) {
                if (mid % 2 == 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[l];
    }


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 20.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                // 奇数在左边
                if (((mid - 1) & 1) == 1) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                // 奇数在左边
                if ((mid & 1) == 1) {
                    right = mid - 1;
                } else {
                    left = mid + 2;
                }
            } else {
                return nums[mid];
            }
        }
        return 0;
    }

}
