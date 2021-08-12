import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/12 09:51
 * @since 1.0
 **/
public class Ac3800 {


    /**
     * 奇数还是偶数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int b = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            boolean isOdd = b % 2 != 0;
            int odd = 0;
            for (int i = 0; i < k; i++) {
                if (isOdd) {
                    odd += arr[i] % 2 == 0 ? 0 : 1;
                }
            }
            if (!isOdd) {
                odd += arr[arr.length - 1] % 2 == 0 ? 0 : 1;
            }

            System.out.println(odd % 2 == 0 ? "even" : "odd");

        }
    }
}
