import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a >
 * @date 2021/6/18 8:23 下午
 * @since 1.0.0
 **/
public class Ac3697 {

    /**
     * 回文子序列
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            boolean flag = true;

            for (int i = 0; i < k - 2; i++) {
                if (!flag) {
                    break;
                }
                for (int j = i + 2; j < k; j++) {
                    if (arr[i] == arr[j]) {
                        System.out.println("YES");
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("NO");
            }
        }
    }
}
