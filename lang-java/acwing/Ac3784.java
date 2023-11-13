import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/30 09:41
 * @since 1.0
 **/
public class Ac3784 {

    /**
     * 交换相邻元素
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        char[] tmp = sc.nextLine().toCharArray();
        for (int i = 0; i < n - 1; i++) {
            if (tmp[i] == '1') {
                int begin = i;
                int len = 1;
                boolean flag = false;
                while (i + 1 < tmp.length && tmp[i + 1] == '1') {
                    i++;
                    len++;
                    flag = true;
                }
                if (flag) {
                    i--;
                }
                Arrays.sort(arr, begin, begin + len + 1);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}
