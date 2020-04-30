import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
     * 玛德，看错题目，携程滑块验证子字符串了😂
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
        System.out.println(isAnagram("err", "rerr"));
    }
}

