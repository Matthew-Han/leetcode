import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:47
 * @description
 * @since 1.0.0
 **/
public class Ac3565 {

    /**
     * 完美矩阵
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int index = 0; index < n; index++) {
            String[] pair = sc.nextLine().split(" ");
            int x = Integer.parseInt(pair[0]);
            int y = Integer.parseInt(pair[1]);
            long ans = 0;
            int[][] arr = new int[x][y];
            for (int i = 0; i < x; i++) {
                String[] s = sc.nextLine().split(" ");
                int[] array = new int[s.length];
                for (int j = 0; j < array.length; j++) {
                    array[j] = Integer.parseInt(s[j]);
                }
                arr[i] = array;
            }
            boolean[][] vis = new boolean[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (vis[i][j]) {
                        continue;
                    }
                    int a = arr[i][j];
                    int b = -1;
                    int c = -1;
                    int d = -1;
                    vis[i][j] = true;
                    if (i != arr.length - i - 1) {
                        vis[arr.length - i - 1][j] = true;
                        b = arr[arr.length - i - 1][j];
                    }
                    if (j != arr[0].length - j - 1) {
                        vis[i][arr[0].length - j - 1] = true;
                        c = arr[i][arr[0].length - j - 1];
                    }
                    if (i != arr.length - i - 1 && j != arr[0].length - j - 1) {
                        vis[arr.length - i - 1][arr[0].length - j - 1] = true;
                        d = arr[arr.length - i - 1][arr[0].length - j - 1];
                    }

                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    if (b != -1) {
                        list.add(b);
                    }
                    if (c != -1) {
                        list.add(c);
                    }
                    if (d != -1) {
                        list.add(d);
                    }
                    Collections.sort(list);
                    int curr = 0;
                    if (list.size() % 2 == 0) {
                        curr = (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
                    } else {
                        curr = list.get(list.size() / 2);
                    }
                    // System.out.println("curr : " + curr);
                    ans += Math.abs(a - curr);
                    if (b != -1) {
                        ans += Math.abs(b - curr);
                    }
                    if (c != -1) {
                        ans += Math.abs(c - curr);
                    }
                    if (d != -1) {
                        ans += Math.abs(d - curr);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
