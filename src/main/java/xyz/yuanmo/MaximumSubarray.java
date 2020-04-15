package xyz.yuanmo;

/**
 * @ClassName MaximumSubarray
 * @Description #53 最大子序和
 * @Author MatthewHan
 * @Date 2020/4/14 10:52
 * @Version 1.0
 **/
public class MaximumSubarray {

    /**
     * LeetCode解法
     * 看完感觉自己是个智障
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;


    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-1111, -10, -122, -12, -12, -24, -66}));
    }
}
