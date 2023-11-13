package 第255场周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/23 10:43
 * @since 1.0
 **/
public class No1979 {


    /**
     * 找出数组的最大公约数
     *
     * @param nums
     * @return
     */
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0], nums[nums.length - 1]);

    }

    public int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

}
