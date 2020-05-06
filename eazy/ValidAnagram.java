import java.util.*;

/**
 * @ClassName ValidAnagram
 * @Description #242 有效的字母异位词
 * @Author MatthewHan
 * @Date 2020/4/30 17:35
 * @Version 1.0
 **/
public class ValidAnagram {

    /**
     * 执行用时 : 87 ms , 在所有 Java 提交中击败了 5.22% 的用户
     * 内存消耗 : 49.2 MB , 在所有 Java 提交中击败了 5.66% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        String[] s1 = s.split("");
        String[] s2 = t.split("");
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }

    /**
     * 执行用时 : 31 ms , 在所有 Java 提交中击败了 9.31% 的用户
     * 内存消耗 : 40.9 MB , 在所有 Java 提交中击败了 5.66% 的用户
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagramByHash(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        Map<Character, Integer> map1 = new HashMap<>(len * 4 / 3 + 1);
        Map<Character, Integer> map2 = new HashMap<>(len * 4 / 3 + 1);
        for (int i = 0; i < len; i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        System.out.println("map1 = " + map1);
        System.out.println("map2 = " + map2);
        System.out.println("map1.equals(map2) = " + map1.equals(map2));
        return map1.equals(map2);
    }

    /**
     * 玛德，看错题目，写成滑块验证子字符串了😂
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSlider(String s, String t) {
        int block = t.length();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (i + block > size) {
                return false;
            } else {
                if (s.substring(i, i + block).equals(t)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(isAnagramByHash("dgqztusjuu", "dqugjzutsu"));
    }
}

