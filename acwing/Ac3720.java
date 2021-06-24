import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/24 09:48
 * @since 1.0
 **/
public class Ac3720 {

    /**
     * 数组重排
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int x = sc.nextInt();
            int[] arr1 = new int[k];
            int[] arr2 = new int[k];
            for (int i = 0; i < k; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < k; i++) {
                arr2[i] = sc.nextInt();
            }
            boolean flag = true;
            for (int i = 0; i < k; i++) {
                if (arr1[i] + arr2[k - i - 1] > x) {
                    System.out.println("No");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Yes");
            }

        }
    }
}
