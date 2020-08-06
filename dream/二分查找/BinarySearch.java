package 二分查找;

/**
 * @ClassName BinarySearch
 * @Description #704 二分查找
 * @Author MatthewHan
 * @Date 2020/5/31 04:30
 * @Version 1.0
 **/
public class BinarySearch {

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40.8 MB , 在所有 Java 提交中击败了 5.26% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 防止溢出
            // int mid = left + (right - left) / 2;
            // h或者使用无符号右移
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 19));
    }
}
