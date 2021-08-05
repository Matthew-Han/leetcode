import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/5 09:29
 * @since 1.0
 **/
public class Ac3792 {

    /**
     * 质数问题
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int target = n - 1;
            boolean[] vis = new boolean[n + 1];
            int max = (int) Math.sqrt(n);
            for (int j = 2; j <= max; j++) {
                for (int i = 0; i <= n; i++) {
                    if (i != j && i % j == 0) {
                        vis[i] = true;
                    }
                }
            }
            int cnt = 1;
            int prev = 2;
            for (int i = 3; i <= n; i++) {
                if (!vis[i]) {
                    if (prev + i + 1 <= n && !vis[prev + i + 1]) {
                        cnt++;
                    }
                    prev = i;
                }
            }
            System.out.println(cnt >= k ? "YES" : "NO");
        }
    }
}
