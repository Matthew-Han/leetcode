package 第235场周赛;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/5 02:35
 **/
public class No1818 {

    long mod = 1000000000 + 7;

    /**
     * #1818 绝对差值和
     * 执行用时： 133 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 56.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] sortNums = new int[nums1.length];
        System.arraycopy(nums1, 0, sortNums, 0, len);
        Arrays.sort(sortNums);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
            sum %= mod;
        }
        int ans = sum;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }
            int tmp = sum;
            int index = brainySearch(sortNums, nums2[i]);
            tmp -= Math.abs(Math.abs(sortNums[index] - nums2[i]) - Math.abs(nums2[i] - nums1[i]));
            ans = Math.min(ans, tmp);
        }
        return ans;
    }

    public int brainySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            ans = mid;
        }
        if (ans + 1 < arr.length && Math.abs(arr[ans] - target) > Math.abs(arr[ans + 1] - target)) {
            return ans + 1;
        }
        if (ans - 1 >= 0 && Math.abs(arr[ans] - target) > Math.abs(arr[ans - 1] - target)) {
            return ans - 1;
        }
        return ans;
    }
}
