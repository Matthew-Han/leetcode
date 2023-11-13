import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/23 09:21
 * @since 1.0
 **/
public class Ac3711 {

    static boolean flag;

    /**
     * 方格涂色
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = sc.nextInt();
            }
            flag = false;
            int[] min = new int[4];
            dfs(min, arr, 0, k);
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    public static void dfs(int[] min, int[] arr, int i, int k) {
        if (i == 4) {
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                cnt += min[j] <= arr[j] ? 1 : 0;
            }
            if (cnt == 4) {
                flag = true;
            }
            return;
        }
        if (arr[i] == k) {
            min[(i + 1) % 4]++;
            min[(i + 3) % 4]++;
            dfs(min, arr, i + 1, k);
            min[(i + 1) % 4]--;
            min[(i + 3) % 4]--;
        } else if (arr[i] == k - 1) {
            min[(i + 1) % 4]++;
            dfs(min, arr, i + 1, k);
            min[(i + 1) % 4]--;

            min[(i + 3) % 4]++;
            dfs(min, arr, i + 1, k);
            min[(i + 3) % 4]--;
        } else {
            dfs(min, arr, i + 1, k);
        }
    }
}
