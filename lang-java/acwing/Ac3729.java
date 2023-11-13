import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a >
 * @date 2021/6/26 7:25 下午
 * @since 1.0
 **/
public class Ac3729 {


    /**
     * 改变数组元素
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] arr = new int[k];
            int[] tmp = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            int left = k;
            for (int i = k - 1; i >= 0; i--) {
                if (arr[i] > 0) {
                    left = Math.min(left, i - arr[i] + 1);
                }
                if (i >= left) {
                    tmp[i] = 1;
                }
            }
            for (int i = 0; i < k; i++) {
                System.out.print(tmp[i] + " ");
            }
            System.out.println();
        }

    }
}
