package 第257场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/6 17:53
 * @since 1.0
 **/
public class No1995 {

    /**
     * 统计特殊四元组
     *
     * @param nums
     * @return
     */
    public int countQuadruplets(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int a = k + 1; a < nums.length; a++) {
                        if (nums[i] + nums[j] + nums[k] == nums[a]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
