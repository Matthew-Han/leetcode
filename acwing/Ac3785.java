import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/2 09:50
 * @since 1.0
 **/

public class Ac3785 {

    /**
     * 战舰
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        char[][] m = new char[n][n];
        for (int i = 0; i < n; i++) {
            m[i] = sc.nextLine().toCharArray();
        }
        int[] xy = new int[]{1, 1};
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == '.') {
                    int curr = fuck(m, i, j, n, k);
                    if (max < curr) {
                        max = curr;
                        xy[0] = i + 1;
                        xy[1] = j + 1;

                    }
                }
            }
        }
        System.out.println(xy[0] + " " + xy[1]);
    }

    public static int fuck(char[][] m, int x, int y, int n, int k) {
        int ans = 0;
        int cnt = 0;
        for (int i = x; i < x + k; i++) {
            if (i >= n || m[i][y] == '#') {
                break;
            }

            cnt++;
        }
        cnt--;
        for (int i = x; i > x - k; i--) {
            if (i < 0 || m[i][y] == '#') {
                break;
            }
            cnt++;
        }

        ans += cnt >= k ? cnt - k + 1 : 0;
        cnt = 0;
        for (int i = y; i < y + k; i++) {
            if (i >= n || m[x][i] == '#') {
                break;
            }
            cnt++;
        }
        cnt--;
        for (int i = y; i > y - k; i--) {
            if (i < 0 || m[x][i] == '#') {
                break;
            }
            cnt++;
        }
        ans += cnt >= k ? cnt - k + 1 : 0;
        return ans;

    }
}
