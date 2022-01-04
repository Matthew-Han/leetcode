import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/4 11:06
 * @since 1.0
 **/
public class Ac2058 {

    /**
     * 笨拙的手指
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Set<Integer> vis = new HashSet<>();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            String tmp = prefix.toString() + ('1' - str1.charAt(i)) + (new String(str1.toCharArray(), i + 1, str1.length() - i - 1)).toString();
            prefix.append(str1.charAt(i));

            vis.add(Integer.valueOf(tmp, 2));
        }
        prefix = new StringBuilder();

        for (int i = 0; i < str2.length(); i++) {
            String[] tmp = new String[2];
            tmp[0] = prefix.toString() + convert(str2.charAt(i))[0] + (new String(str2.toCharArray(), i + 1, str2.length() - i - 1)).toString();
            tmp[1] = prefix.toString() + convert(str2.charAt(i))[1] + (new String(str2.toCharArray(), i + 1, str2.length() - i - 1)).toString();
            prefix.append(str2.charAt(i));
            for (int j = 0; j < 2; j++) {
                if (vis.contains(Integer.valueOf(tmp[j], 3))) {
                    System.out.println(Integer.valueOf(tmp[j], 3));
                    break;
                }
            }

        }

    }

    public static char[] convert(char n) {
        if (n == '0') {
            return new char[]{'1', '2'};
        } else if (n == '1') {
            return new char[]{'0', '2'};
        } else {
            return new char[]{'0', '1'};
        }
    }
}
