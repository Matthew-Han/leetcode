import java.util.*;

/**
 * @ClassName IsomorphicStrings
 * @Description #205 同构字符串
 * @Author MatthewHan
 * @Date 2020/4/27 16:14
 * @Version 1.0
 **/
public class No205 {

    /**
     * 注意是LinkedHashMap
     * 执行用时 : 12 ms , 在所有 Java 提交中击败了 58.27% 的用户
     * 内存消耗 : 40.8 MB , 在所有 Java 提交中击败了 5.88% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {

        Map<Character, Integer> map1 = new LinkedHashMap<>(s.length() / 3 * 4 + 1);
        Map<Character, Integer> map2 = new LinkedHashMap<>(s.length() / 3 * 4 + 1);
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), i);
        }
        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), i);
        }
        System.out.println(map1.values());
        System.out.println(map2.values());
        return map1.values().toString().equals(map2.values().toString());


    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("title", "paper"));
    }
}
