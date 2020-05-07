import java.util.*;

/**
 * @ClassName WordPattern
 * @Description #290 单词规律
 * @Author MatthewHan
 * @Date 2020/5/7 16:05
 * @Version 1.0
 **/
public class WordPattern {

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

        if (str.length() == 0 && pattern.length() == 0) {
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
        System.out.println(map1);
        System.out.println(map2);

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

        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));

        return Arrays.toString(ints1).equals(Arrays.toString(ints2));
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("adda", "dog cat cat dog"));
    }
}
