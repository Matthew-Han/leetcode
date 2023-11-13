import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LargestNumberAtLeastTwiceOfOthers
 * @Description #747 至少是其他数字两倍的最大数
 * @Author MatthewHan
 * @Date 2020/6/15 16:55
 * @Version 1.0
 **/
public class No747 {

    public int date20220113(int[] nums) {
        int max = Integer.MIN_VALUE;
        int second = -1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                ans = i;
            } else if (nums[i] < max && nums[i] > second) {
                second = nums[i];
            }
        }
        return second * 2 <= max ? ans : -1;
    }

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 16.24% 的用户
     * 内存消耗 : 38.2 MB , 在所有 Java 提交中击败了 6.25% 的用户
     *
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        int max = 0;

        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
            list.add(nums[i]);
        }
        list.remove((Object) max);
        int sec = -1;
        for (Integer integer : list) {
            sec = Math.max(sec, integer);
        }
        System.out.println("max = " + max);
        System.out.println("maxIndex = " + maxIndex);
        System.out.println("sec = " + sec);
        if (max / 2 >= sec) {
            return maxIndex;
        } else {
            return -1;
        }
    }


}
