package 二维数组;

import java.util.*;

/**
 * @ClassName NumberOfEquivalentDominoPairs
 * @Description #1128 等价多米诺骨牌对的数量
 * @Author MatthewHan
 * @Date 2020/7/6 17:17
 * @Version 1.0
 **/
public class NumberOfEquivalentDominoPairs {

    /**
     * 执行用时： 31 ms , 在所有 Java 提交中击败了 10.22% 的用户
     * 内存消耗： 49.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param dominoes
     * @return
     */
    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] n : dominoes) {
            String key = Math.min(n[0], n[1]) + "" + Math.max(n[0], n[1]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int sum = 0;
        System.out.println(map);
        // map.entrySet().removeIf(item -> item.getValue().equals(1));
        System.out.println(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value > 1) {
                int temp = 0;
                for (int n = value - 1; n > 0; n--) {
                    temp += n;
                }
                sum += temp;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs(new int[][]{{2, 1}, {1, 2}, {1, 2}, {1, 2}, {2, 1}, {1, 1}, {1, 2}, {2, 2}}));
    }
}
