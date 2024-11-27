import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MaxConsecutiveOnes
 * @Description #485 最大连续1的个数
 * @Author MatthewHan
 * @Date 2020/5/18 09:09
 * @Version 1.0
 **/
public class No485 {

    /**
     * 执行用时 : 11 ms , 在所有 Java 提交中击败了 6.38% 的用户
     * 内存消耗 : 41.1 MB , 在所有 Java 提交中击败了 5.26% 的用户
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        List<Integer> diff = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        // 开头结尾无0+0
        if (list.getFirst() != 0) {
            list.addFirst(0);
        }
        if (list.getLast() != 0) {
            list.add(list.size(), 0);
        }

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                diff.add(i);
            }
        }
        for (int i = 0; i < diff.size(); i++) {
            if (i >= 1 && max < diff.get(i) - diff.get(i - 1)) {
                max = diff.get(i) - diff.get(i - 1);
            }
        }
        return Math.max((max - 1), 0);
    }

    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 47.17% 的用户
     * 内存消耗 : 41.3 MB , 在所有 Java 提交中击败了 5.26% 的用户
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnesPro(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            }
            if (nums[i] == 0) {
                if (max < count) {
                    max = count;
                }
                count = 0;
            }
            if (i == nums.length - 1) {
                if (max < count) {
                    max = count;
                }
            }
        }
        return max;
    }

}
