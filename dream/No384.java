import java.util.Random;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/11/22 11:08
 * @since 1.0
 **/
public class No384 {


    int[] cache;
    int[] nums;
    Random random;

    /**
     * 打乱数组
     *
     * @param nums
     */
    public No384(int[] nums) {
        this.cache = nums.clone();
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return cache;
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int rnd = random.nextInt(nums.length);
            if (i != rnd) {
                swap(i, rnd);
            }
        }
        return nums;
    }

    public void swap(int x, int y) {
        nums[x] ^= nums[y];
        nums[y] ^= nums[x];
        nums[x] ^= nums[y];
    }


}
