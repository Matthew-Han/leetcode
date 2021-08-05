import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/4 10:57
 * @since 1.0
 **/
public class Ac3791 {

    /**
     * 解码
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[] arr = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean flag = arr.length % 2 == 0;
        for (int i = 0; i < n; i++) {
            if (flag && i != n - 1) {
                sb.insert(0, arr[i]);
            } else {
                sb.append(arr[i]);
            }
            flag = !flag;
        }
        System.out.println(sb.toString());
    }
}
