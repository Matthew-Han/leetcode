import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/23 17:02
 * @since 1.0
 **/
public class Ac3705 {

    /**
     * 子集mex值
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] arr = new int[101];
            for (int i = 0; i < k; i++) {
                arr[sc.nextInt()]++;
            }
            int sum = 0;
            boolean flag = true;
            for (int i = 0; i < 100; i++) {
                if (arr[i] == 0) {
                    sum += i;
                    flag = false;
                    break;
                } else {
                    arr[i]--;
                }
            }
            if (flag) {
                sum += 100;
            }

            flag = true;
            for (int i = 0; i < 100; i++) {
                if (arr[i] == 0) {
                    sum += i;
                    flag = false;
                    break;
                } else {
                    arr[i]--;
                }
            }
            if (flag) {
                sum += 100;
            }
            System.out.println(sum);
        }
    }
}
