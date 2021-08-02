package 第10场周赛;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/2 09:53
 * @since 1.0
 **/
public class Ac3789 {

    /**
     * 隐藏字符串
     * <p>
     * 第一次 ak 周赛!虽然是 y 总把题变简单了
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int[] bucket = new int[26];
        long max = 0;
        for (char value : arr) {
            bucket[value - 'a']++;
            max = Math.max(bucket[value - 'a'], max);
        }
        List<Map<Character, Long>> list = new ArrayList<>(arr.length);
        Map<Character, Long> f = new HashMap<Character, Long>() {
            {
                put(arr[0], 1L);
            }
        };
        list.add(f);
        for (int i = 1; i < arr.length; i++) {
            Map<Character, Long> prev = list.get(i - 1);
            Map<Character, Long> curr = new HashMap<>(prev);
            curr.put(arr[i], curr.getOrDefault(arr[i], 0L) + 1);
            list.add(curr);
        }
        Map<String, Long> cnt = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            char c = arr[i];
            Map<Character, Long> curr = list.get(i);
            for (Map.Entry<Character, Long> e : curr.entrySet()) {
                String k = "" + e.getKey() + c;
                long v = e.getValue();
                cnt.put(k, cnt.getOrDefault(k, 0L) + v);
                if (e.getKey() == c) {
                    cnt.put(k, cnt.get(k) - 1);
                }
                max = Math.max(max, cnt.get(k));
            }
        }
        System.out.println(max);
    }
}
