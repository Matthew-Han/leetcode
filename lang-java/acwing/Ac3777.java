import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/26 09:51
 * @since 1.0
 **/
public class Ac3777 {

    /**
     * 砖块
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            sc.nextLine();
            char[] arr = sc.nextLine().toCharArray();
            int cntW = 0;
            int cntB = 0;
            for (int i = 0; i < k; i++) {
                cntW += arr[i] == 'W' ? 1 : 0;
                cntB += arr[i] == 'B' ? 1 : 0;
            }
            if ((cntW & 1) == 1 && (cntB & 1) == 1) {
                System.out.println(-1);
                continue;
            }
            if (cntW == 0 || cntB == 0) {
                System.out.println(0);
                continue;
            }
            int cnt = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i < k - 1; i++) {
                if (arr[i] != arr[i - 1]) {
                    queue.offer(i);
                    arr[i] = arr[i] == 'W' ? 'B' : 'W';
                    arr[i + 1] = arr[i + 1] == 'W' ? 'B' : 'W';
                    cnt++;
                }
            }
            for (int i = k - 2; i > 0; i--) {
                if (arr[i] != arr[i + 1]) {
                    queue.offer(i - 1);
                    arr[i] = arr[i] == 'W' ? 'B' : 'W';
                    arr[i - 1] = arr[i - 1] == 'W' ? 'B' : 'W';
                    cnt++;
                }
            }
            System.out.println(cnt);
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + 1 + " ");
            }
            System.out.println();
        }
    }
}
