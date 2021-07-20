import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/20 09:31
 * @since 1.0
 **/
public class Ac3773 {

    /**
     * 兔子跳
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int target = sc.nextInt();
            int max = 0xc0c0c0c0;
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
            }
            boolean flag = true;
            for (int a : arr) {
                if (a == target) {
                    System.out.println(1);
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                continue;
            }

            if (max > target) {
                System.out.println(2);
            } else {
                System.out.println((target + max - 1) / max);
            }
        }
    }
}
