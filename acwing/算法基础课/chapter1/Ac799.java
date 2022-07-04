package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/7/4 17:20 04
 * @since 1.0
 **/
public class Ac799 {

    /**
     * 最长连续不重复子序列
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[] s = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length; i++) {
            if (map.containsKey(s[i])) {
                left = Math.max(left, map.get(s[i]) + 1);
            }
            map.put(s[i], i);
            max = Math.max(max, i - left + 1);
        }
        System.out.println(max);
    }
}
