package 第55场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/28 14:12
 * @since 1.0
 **/
public class No1909 {

    /**
     * #1909 删除一个元素
     *
     * @param nums
     * @return
     */
    public boolean canBeIncreasing(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                cnt++;
                if (i - 1 >= 0 && nums[i - 1] >= nums[i + 1]) {
                    if (i + 2 < nums.length && nums[i] >= nums[i + 2]) {
                        return false;
                    }
                }
            }
        }
        return cnt <= 1;
    }
}
