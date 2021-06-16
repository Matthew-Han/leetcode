/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/23 05:13
 * @description
 * @since 1.0.0
 **/
public class No810 {

    /**
     * #810 黑板异或游戏
     *
     * @param nums
     * @return
     */
    public boolean xorGame(int[] nums) {
        int prev = 0;
        for (int n : nums) {
            prev ^= n;
        }
        return prev == 0 || nums.length % 2 == 0;
    }
}
