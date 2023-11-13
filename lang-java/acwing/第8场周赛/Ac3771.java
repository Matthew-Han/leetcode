package 第8场周赛;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/17 18:57
 * @since 1.0
 **/
public class Ac3771 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long max = 0xc0c0c0c0;
        Map<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            map.put(arr[i] - i, map.getOrDefault(arr[i] - i, 0L) + arr[i]);
        }
        for (Map.Entry<Integer, Long> e : map.entrySet()) {
            max = Math.max(max, e.getValue());
        }
        System.out.println(max);


    }
}
