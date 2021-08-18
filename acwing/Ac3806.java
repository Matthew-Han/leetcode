import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/17 11:06
 * @since 1.0
 **/
public class Ac3806 {

    /**
     * 最小化字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            sc.nextLine();
            char[] arr = sc.nextLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (flag && arr[i] > arr[i + 1]) {
                    flag = false;
                } else {
                    sb.append(arr[i]);
                }
            }
            if (!flag) {
                sb.append(arr[k - 1]);
            }
            System.out.println(sb);
        }
    }
}
