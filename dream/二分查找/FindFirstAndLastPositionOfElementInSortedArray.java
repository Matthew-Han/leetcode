package 二分查找;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FindFirstAndLastPositionOfElementInSortedArray
 * @Description #34 在排序数组中查找元素的第一个和最后一个位置
 * @Author MatthewHan
 * @Date 2020/8/24 11:15
 * @Version 1.0
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 43.1 MB , 在所有 Java 提交中击败了 31.67% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int ans1 = margin(nums, left, mid, target, true, mid);
                int ans2 = margin(nums, mid, right, target, false, mid);
                return new int[]{ans1, ans2};
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * @param nums
     * @param left
     * @param right
     * @param target
     * @param direction true 左边
     * @return
     */
    public static int margin(int[] nums, int left, int right, int target, boolean direction, int prev) {
        int point = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                point = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            Map<String,String> map = new HashMap<>();
            map.get("ss");
        }

        // 当point == -1说明这轮的sub数组没有target，就返回prev的下标
        if (point == -1) {
            return prev;
        } else {
            // direction方向，true一直往左边找，最大值是下标point - 1
            if (direction) {
                return margin(nums, left, point - 1, target, direction, point);
            } else {
                return margin(nums, point + 1, right, target, direction, point);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 3}, 4)));
    }
}
