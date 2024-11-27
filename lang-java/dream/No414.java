import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ClassName ThirdMaximumNumber
 * @Description #414 第三大的数
 * @Author MatthewHan
 * @Date 2020/5/14 15:20
 * @Version 1.0
 **/
public class No414 {

    /**
     * LinkedHashSet，不然白排序了
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 31.37% 的用户
     * 内存消耗 : 39.6 MB , 在所有 Java 提交中击败了 11.11% 的用户
     *
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] fuck = new int[set.size()];
        int i = 0;
        for (Integer value : set) {
            fuck[i] = value;
            i++;
        }
        if (fuck.length < 3) {
            return fuck[fuck.length - 1];
        }
        return fuck[fuck.length - 3];
    }
}
