import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName BuddyStrings
 * @Description #859 亲密字符串
 * @Author MatthewHan
 * @Date 2020/6/20 20:03
 * @Version 1.0
 **/
public class No859 {

    /**
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 18.13% 的用户
     * 内存消耗 : 39.7 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean buddyStrings(String a, String b) {
        if (a.length() != b.length() || a.length() <= 1) {
            return false;
        }

        if (a.equals(b)) {
            Set<Character> set = new HashSet<>(a.length());
            for (int i = 0; i < a.length(); i++) {
                set.add(a.charAt(i));
            }
            if (set.size() == a.length()) {
                return false;
            }

        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                sb1.append(a.charAt(i));
                sb2.append(b.charAt(i));
                if (count > 2) {
                    return false;
                }
            }

        }
        if (sb1.length() == 2) {
            return sb2.toString().equals(sb1.reverse().toString());
        }
        if (count == 1) {
            return false;
        }
        System.out.println("count = " + count);

        return true;

    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ba"));
    }

}
