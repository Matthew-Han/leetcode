import java.util.*;

/**
 * @ClassName WordPattern
 * @Description #290 单词规律
 * @Author MatthewHan
 * @Date 2020/5/7 16:05
 * @Version 1.0
 **/
public class No290 {

    /**
     * 蛤希表
     * 执行用时 : 16 ms , 在所有 Java 提交中击败了 6.12% 的用户
     * 内存消耗 : 40 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {

        if (str.isEmpty() && pattern.isEmpty()) {
            return true;
        }
        int j = 1;
        int k = 1;
        Map<Character, Integer> map1 = new HashMap<>(pattern.length() * 4 / 3 + 1);
        Map<String, Integer> map2 = new HashMap<>(pattern.length() * 4 / 3 + 1);
        for (int i = 0; i < pattern.length(); i++) {
            if (!map1.containsKey(pattern.charAt(i))) {
                map1.put(pattern.charAt(i), j);
                j++;
            }
        }
        for (int i = 0; i < str.split(" ").length; i++) {
            if (!map2.containsKey(str.split(" ")[i])) {
                map2.put(str.split(" ")[i], k);
                k++;
            }
        }
        Integer[] ints1 = new Integer[pattern.length()];
        Integer[] ints2 = new Integer[str.split(" ").length];

        for (int i = 0; i < pattern.length(); i++) {
            for (int l = 0; l < map1.size(); l++) {
                if (map1.containsKey(pattern.charAt(i))) {
                    ints1[i] = map1.get(pattern.charAt(i));
                    break;
                }
            }
        }
        for (int i = 0; i < str.split(" ").length; i++) {
            for (int l = 0; l < map2.size(); l++) {
                if (map2.containsKey(str.split(" ")[i])) {
                    ints2[i] = map2.get(str.split(" ")[i]);
                    break;
                }
            }
        }
        return Arrays.toString(ints1).equals(Arrays.toString(ints2));
    }

    /**
     * 和 #205 同构字符串做法类似，但是必须是LinkedHashMap
     * 执行用时 : 8 ms , 在所有 Java 提交中击败了 6.12% 的用户
     * 内存消耗 : 40.5 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPatternPro(String pattern, String str) {
        Map<Character, Integer> map1 = new LinkedHashMap<>(pattern.length() * 4 / 3 + 1);
        Map<String, Integer> map2 = new LinkedHashMap<>(pattern.length() * 4 / 3 + 1);

        for (int i = 0; i < pattern.length(); i++) {
            map1.put(pattern.charAt(i), i);
        }
        for (int i = 0; i < str.split(" ").length; i++) {
            map2.put(str.split(" ")[i], i);
        }
        return map1.values().toString().equals(map2.values().toString());
    }
}
