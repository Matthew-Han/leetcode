import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/9 09:44
 * @since 1.0
 **/
public class Ac3761 {

    /**
     * 唯一最小数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] arr = new int[k];
            Map<Integer, Integer> vis = new HashMap<>();
            Map<Integer, Integer> index = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
                index.put(arr[i], i + 1);
                vis.put(arr[i], vis.getOrDefault(arr[i], 0) + 1);
            }
            boolean flag = true;
            for (Map.Entry<Integer, Integer> entry : index.entrySet()) {
                if (vis.get(entry.getKey()) == 1) {
                    System.out.println(entry.getValue());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(-1);
            }
        }

    }
}
