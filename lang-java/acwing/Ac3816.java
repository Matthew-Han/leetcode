import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/27 17:41
 * @since 1.0
 **/
public class Ac3816 {


    /**
     * 移动元素
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] arr = new int[k];
            int[] reverseArr = new int[k];
            long sum = 0L;
            Map<Long, Integer> cache = new HashMap<>();
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
                reverseArr[k - i - 1] = arr[i];
                sum += arr[i];
                cache.put((long) arr[i], cache.getOrDefault((long) arr[i], 0) + 1);
            }
            if ((sum & 1) == 1) {
                System.out.println("NO");
                continue;
            }
            if (check(arr, sum, cache) || check(reverseArr, sum, new HashMap<>(cache))) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }

    public static boolean check(int[] arr, long sum, Map<Long, Integer> cache) {
        long t = 0;
        Map<Long, Integer> receiveMap = new HashMap<>();
        for (int j : arr) {
            t += j;
            if (t * 2 == sum) {
                return true;
            }
            cache.put((long) j, cache.get((long) j) - 1);
            receiveMap.put((long) j, receiveMap.getOrDefault((long) j, 0) + 1);
            long key = Math.abs(sum / 2 - t);
            if (t * 2 < sum) {
                if (cache.containsKey(key) && cache.get(key) > 0) {
                    return true;
                }
            } else {
                if (receiveMap.containsKey(key) && receiveMap.get(key) > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
