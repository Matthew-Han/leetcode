package 第12场周赛;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/20 17:38
 * @since 1.0
 **/
public class Ac3803 {

    /**
     * 数组去重
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            boolean[] vis = new boolean[1001];
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = k - 1; i >= 0; i--) {
                if (!vis[arr[i]]) {
                    stack.add(arr[i]);

                }
                vis[arr[i]] = true;
            }
            System.out.println(stack.size());
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }
}
