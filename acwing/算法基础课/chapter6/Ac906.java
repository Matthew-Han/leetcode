package 算法基础课.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/6/27 16:03 27
 * @since 1.0
 **/
public class Ac906 {


    /**
     * 区间分组
     * <p>
     * TreeMap 的 key 存放最右侧的端点，value 存放右端点个数。
     * <p>
     * 先进行右端点从小到大排序，这样后面的区间右端点都是比前面的大，无论后面的区间左端点有多「左边」都无所谓，通过 TreeMap 查找有没有比当前区间的左端点的小的 entry：
     * <p>
     * 0. 如果有则他们合并，更新 TreeMap，减少一个 value 的个数（为 0 则直接删除），添加一个新的右端点入 TreeMap
     * （这里需要用 getOrDefault 方法先查是不是已经有了，有的话需要 + 1，没有的话就是 1）；
     * <p>
     * 1. 如果没有则新起一个 entry
     * （这里需要用 getOrDefault 方法先查是不是已经有了，有的话需要 + 1，没有的话就是 1），
     * 另外 ans++；
     *
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(sc.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        int ans = 1;
        TreeMap<Integer, Integer> set = new TreeMap<>();
        set.put(arr[0][1], 1);
        for (int i = 1; i < n; i++) {
            Map.Entry<Integer, Integer> e = set.lowerEntry(arr[i][0]);
            if (e != null) {
                int k = e.getKey();
                int v = e.getValue();
                set.remove(k);
                if (v > 1) {
                    set.put(k, v - 1);
                }
            } else {
                ans++;
            }
            int cnt = set.getOrDefault(arr[i][1], 0);
            set.put(arr[i][1], cnt + 1);
        }
        System.out.println(ans);
    }


}
