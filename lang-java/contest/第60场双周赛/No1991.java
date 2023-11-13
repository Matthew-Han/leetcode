package 第60场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/6 17:50
 * @since 1.0
 **/
public class No1991 {

    /**
     * 找到数组的中间位置
     *
     * @param nums
     * @return
     */
    public int findMiddleIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
