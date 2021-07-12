package 第249场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/12 09:18
 * @since 1.0
 **/
public class No1929 {

    /**
     * 数组串联
     *
     * @param nums
     * @return
     */
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i % nums.length];
        }
        return ans;
    }
}
