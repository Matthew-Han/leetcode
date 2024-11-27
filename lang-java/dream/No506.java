import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName RelativeRanks
 * @Description #506 相对名次
 * @Author MatthewHan
 * @Date 2020/5/19 11:07
 * @Version 1.0
 **/
public class No506 {

    /**
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了 74.13% 的用户
     * 内存消耗 : 41.2 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param nums
     * @return
     */
    public static String[] findRelativeRanks(int[] nums) {
        Map<Integer, String> map = new LinkedHashMap<>(nums.length * 4 / 3 + 1);
        int[] sort = nums.clone();
        Arrays.sort(sort);
        for (int i = 0; i < sort.length; i++) {
            map.put(sort[i], sort.length - i == 1 ? "Gold Medal" : (sort.length - i == 2 ? "Silver Medal" : (sort.length - i == 3 ? "Bronze Medal" : String.valueOf(sort.length - i))));
        }
        String[] strings = new String[map.size()];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = map.get(nums[i]);
        }
        return strings;
    }
}
