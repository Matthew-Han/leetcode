import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:51
 * @description
 * @since 1.0.0
 **/
public class Ac3629 {

    /**
     * 同心圆涂色
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] tmp = sc.nextLine().split(" ");
        double ans = 0D;
        int[] arr = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(arr);
        if ((arr.length & 1) == 0) {
            for (int i = 1; i < arr.length; i += 2) {
                ans += Math.pow(arr[i], 2) * Math.PI - Math.pow(arr[i - 1], 2) * Math.PI;
            }
        } else {
            ans += Math.pow(arr[0], 2) * Math.PI;
            for (int i = 2; i < arr.length; i += 2) {
                ans += Math.pow(arr[i], 2) * Math.PI - Math.pow(arr[i - 1], 2) * Math.PI;
            }
        }
        System.out.printf("%.6f", ans);
    }
}
