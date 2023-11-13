package 双指针;

/**
 * @ClassName CountNumberOfNiceSubarrays
 * @Description #1248 统计「优美子数组」
 * @Author MatthewHan
 * @Date 2020/8/10 11:33
 * @Version 1.0
 **/
public class No1248 {

    /**
     * 略微优化的暴力解法，依然超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays(int[] nums, int k) {
        int limit = nums.length;
        int limitCount = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (limitCount == k) {
                break;
            }
            if ((nums[i] & 1) != 0) {
                limitCount++;
                limit = i;
            }
        }
        int i = 0;
        int count = 0;
        while (i <= limit) {
            int j = i;
            int currCount = 0;
            while (currCount <= k && j < nums.length) {
                if ((nums[j] & 1) != 0) {
                    currCount++;
                }
                if (currCount == k) {
                    count++;
                } else if (currCount > k) {
                    break;
                }
                j++;

            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 3, 2, 1, 32, 2, 1, 3, 2, 1, 1, 1, 1, 2, 3, 2, 3, 1, 2, 4}, 2));
    }

}
