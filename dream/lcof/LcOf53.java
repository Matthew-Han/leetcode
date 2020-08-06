package lcof;

/**
 * @ClassName LcOf53
 * @Description 剑指 Offer #53 - II 0～n-1中缺失的数字
 * @Author MatthewHan
 * @Date 2020/7/20 09:23
 * @Version 1.0
 **/
public class LcOf53 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int m = left + (right - left) / 2;
            if (nums[m] == m) {
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 8, 9}));
        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 7, 8, 9}));
        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9}));
    }
}
