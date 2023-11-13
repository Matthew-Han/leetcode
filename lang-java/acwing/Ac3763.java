import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/13 09:24
 * @since 1.0
 **/
public class Ac3763 {

    /**
     * 数字矩阵
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[][] arr = new int[x][y];
            int cnt = 0;
            int sum = 0;
            int min = 0x3f3f3f3f;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    arr[i][j] = sc.nextInt();
                    if (arr[i][j] <= 0) {
                        cnt++;
                    }
                    int abs = Math.abs(arr[i][j]);
                    sum += abs;
                    min = Math.min(min, abs);
                }
            }
            if ((cnt & 1) == 0) {
                System.out.println(sum);
            } else {
                System.out.println(sum - 2 * min);
            }
        }
    }
}
