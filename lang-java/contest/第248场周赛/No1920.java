package 第248场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/4 10:28
 * @since 1.0
 **/
public class No1920 {

    /**
     * 基于排列构建数组
     *
     * @param nums
     * @return
     */
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

}
