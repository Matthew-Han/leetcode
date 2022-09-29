package 双指针;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/9/15 09:59 15
 * @since 1.0
 **/
public class No670 {
    /**
     * 最大交换
     *
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int l = 0;
        while (l < nums.length) {
            int r = nums.length - 1;
            int idx = r;
            char max = nums[r];
            while (r-- > l) {
                if (nums[r] > max) {
                    max = nums[r];
                    idx = r;
                }
            }
            if (max > nums[l]) {
                nums[l] ^= nums[idx];
                nums[idx] ^= nums[l];
                nums[l] ^= nums[idx];
                break;
            }
            l++;
        }
        return Integer.parseInt(new String(nums));
    }

}
