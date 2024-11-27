import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindAllNumbersDisappearedInAnArray
 * @Description #448 找到所有数组中消失的数字
 * @Author MatthewHan
 * @Date 2020/5/15 13:34
 * @Version 1.0
 **/
public class No448 {

    /**
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗?
     * 你可以假定返回的数组不算在额外空间内。
     * 时间复杂度o(n)，但是使用temp[]数组作为额外空间
     * 执行用时 : 21 ms , 在所有 Java 提交中击败了 24.43% 的用户
     * 内存消耗 : 47.9 MB , 在所有 Java 提交中击败了 79.17% 的用户
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        for (int num : nums) {
            temp[num - 1] = num;
        }
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
