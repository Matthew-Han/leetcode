import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/29 09:33
 * @since 1.0
 **/
public class Ac3730 {

    static List<Integer> res;
    static boolean success;

    /**
     * 寻找队列
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(676 % 26 );
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            res = new ArrayList<>();
            success = false;
            int k = sc.nextInt();
            int[] a = new int[k];
            int[] b = new int[k];
            int[] c = new int[k];
            List<int[]> arr = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < k; i++) {
                b[i] = sc.nextInt();
            }
            for (int i = 0; i < k; i++) {
                c[i] = sc.nextInt();
            }
            arr.add(a);
            arr.add(b);
            arr.add(c);
            boolean[][] vis = new boolean[101][101];
            dfs(vis, arr, new ArrayList<>(), 0, 0);

            for (int r : res) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(boolean[][] vis, List<int[]> arr, List<Integer> list, int index, int prev) {

        if (success) {
            return;
        }
        if (index >= arr.get(0).length) {
            if (!list.get(0).equals(list.get(list.size() - 1))) {
                res = new ArrayList<>(list);
                success = true;
            }
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            int[] curr = arr.get(i);
            if (prev != curr[index] && !vis[index][curr[index]]) {
                vis[index][curr[index]] = true;
                list.add(curr[index]);
                dfs(vis, arr, list, index + 1, curr[index]);
                // System.out.println(list);
                list.remove(list.size() - 1);
            }
        }

    }
}
