/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/12 09:50
 * @since 1.0
 **/
public class No457 {

    /**
     * 环形数组是否存在循环
     *
     * @param nums
     * @return
     */
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = i;
            int val = nums[index];
            boolean flag = val > 0;
            int cnt = 1;
            boolean[] vis = new boolean[len];
            vis[i] = true;
            while (true) {
                val %= len;
                int nextIndex = (val + len + index) % len;
                if (vis[nextIndex]) {
                    if (cnt <= 1 || index == nextIndex) {
                        break;
                    } else {
                        return true;
                    }
                }
                if (nums[nextIndex] < 0 == flag) {
                    break;
                }
                index = nextIndex;
                val = nums[nextIndex];
                vis[nextIndex] = true;
                cnt++;
            }
        }
        return false;
    }
}
