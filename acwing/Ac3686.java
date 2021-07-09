import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a >
 * @date 2021/6/16 7:35 下午
 * @since 1.0.0
 **/
public class Ac3686 {

    /**
     * 移动序列
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
            int l = 0;
            int r = k - 1;
            int ans = 0;
            boolean flag = true;
            boolean flag2 = true;
            while (l < r) {
                while (flag2 && arr[r] != 1) {
                    r--;
                }
                flag2 = false;
                if (flag && arr[l] == 1) {
                    flag = false;
                }
                ans += !flag && arr[l] == 0 ? 1 : 0;
                l++;
            }
            System.out.println(ans);

        }
    }
}
