package 第197场周赛;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NumberOfGoodPairs
 * @Description #5460 好数对的数目
 * @Author MatthewHan
 * @Date 2020/7/12 17:32
 * @Version 1.0
 **/
public class NumberOfGoodPairs {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (Integer value : map.values()) {
            if (value > 1) {
                int temp = 0;
                for (int i = 1; i < value; i++) {
                    temp += i;
                }
                System.out.println("temp = " + temp);
                result += temp;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
    }
}
