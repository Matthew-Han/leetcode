import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:39
 * @description
 * @since 1.0.0
 **/
public class Ac3672 {


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
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            // final out
            for (int i = k - 1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }


}
