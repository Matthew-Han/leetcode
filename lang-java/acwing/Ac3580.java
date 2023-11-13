import java.util.Arrays;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:47
 * @description
 * @since 1.0.0
 **/
public class Ac3580 {

    /**
     * 整数配对
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] tmp = sc.nextLine().split(" ");
        int[] arr = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i += 2) {
            ans += arr[i + 1] - arr[i];
        }
        System.out.println(ans);
    }
}
