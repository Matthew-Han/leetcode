import java.util.*;

/**
 * @ClassName DegreeOfAnArray
 * @Description #697 数组的度
 * @Author MatthewHan
 * @Date 2020/5/29 12:42
 * @Version 1.0
 **/
public class DegreeOfAnArray {


    /**
     * 执行用时 : 52 ms , 在所有 Java 提交中击败了 20.23% 的用户
     * 内存消耗 : 45 MB , 在所有 Java 提交中击败了 6.25% 的用户
     *
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length * 4 / 3 + 1);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = -1;
        List<Integer> maxArray = new ArrayList<>();
        for (Integer value : map.values()) {
            max = Math.max(value, max);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                maxArray.add(entry.getKey());
            }
        }
        int len = nums.length;
        for (Integer integer : maxArray) {
            int low = 0;
            int high = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == integer) {
                    low = i;
                    break;
                }
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] == integer) {
                    high = j;
                    break;
                }
            }
            len = Math.min((high - low + 1), len);

        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 1, 2, 3, 2}));
    }
}
