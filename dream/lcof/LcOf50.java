package lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LcOf50
 * @Description 剑指 Offer #50 第一个只出现一次的字符
 * @Author MatthewHan
 * @Date 2020/7/20 00:35
 * @Version 1.0
 **/
public class LcOf50 {

    /**
     * 利用lastIndex方法筛选出只出现一次的字符，然后比较他们的索引下标，选出最小的索引
     * <p>
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public char firstUniqChar3(String s) {
        int minIndex = Integer.MAX_VALUE;
        for (int c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            // 字符串只出现1次的
            if (index != -1 && s.lastIndexOf(c) == index) {
                minIndex = Math.min(minIndex, index);
            }
        }
        return minIndex == Integer.MAX_VALUE ? ' ' : s.charAt(minIndex);
    }

    /**
     * 经典桶排
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 84.30% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        int[] ascii = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ascii[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ascii[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 执行用时： 35 ms , 在所有 Java 提交中击败了 30.19% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        // 剔除不符合的情况，反而更快？？
        map.entrySet().removeIf(item -> item.getValue() > 1);
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

}
