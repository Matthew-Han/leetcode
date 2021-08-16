import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/16 09:43
 * @since 1.0
 **/
public class Ac3802 {

    /**
     * 消灭数组
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
            System.out.println(dfs(arr, 0, k));

        }
    }

    public static int dfs(int[] arr, int left, int right) {
        boolean flag = true;
        for (int i = left; i < right - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return right - left;
        } else {
            return Math.max(dfs(arr, left, (left + right) >>> 1), dfs(arr, (left + right) >>> 1, right));
        }
    }
}
