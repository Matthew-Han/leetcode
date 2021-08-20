package 第12场周赛;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/20 17:37
 * @since 1.0
 **/
public class Ac3804 {

    /**
     * 构造字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int len = sc.nextInt();
            sc.nextLine();
            char[] arr = sc.nextLine().toCharArray();
            TreeSet<Character> set = new TreeSet<>(Character::compare);
            char minChar = 'z';
            for (char a : arr) {
                set.add(a);
                if (a < minChar) {
                    minChar = a;
                }
            }
            char[] ans = new char[len];
            if (len <= k) {
                boolean flag = true;
                int index = 0;
                int start = len - 1;
                for (int i = start; i >= 0; i--) {
                    if (flag && set.higher(arr[i]) != null) {
                        ans[i] = set.higher(arr[i]);
                        index = i;
                        flag = false;
                    } else {
                        ans[i] = arr[i];
                    }
                }
                for (int i = index + 1; i < len; i++) {
                    ans[i] = minChar;
                }
            } else {
                System.arraycopy(arr, 0, ans, 0, k);
                for (int i = k; i < len; i++) {
                    ans[i] = minChar;
                }
            }
            System.out.println(new String(ans));

        }
    }

}
