package 动态规划;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/1 12:36 01
 * @since 1.0
 **/
public class No553 {

    /**
     * 最优除法
     *
     * @param nums
     * @return
     */
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder(String.valueOf(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            sb.append("/");
            if (i == 1 && nums.length > 2) {
                sb.append("(");
            }
            sb.append(nums[i]);
            if (i == nums.length - 1 && nums.length > 2) {
                sb.append(")");
            }
        }
        return sb.toString();
    }
}
