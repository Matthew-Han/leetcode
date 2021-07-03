package 第6场周赛;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/3 18:59
 * @since 1.0
 **/
public class Ac3734 {

    static TreeSet<Long> cache = new TreeSet<>();

    /**
     * 求和
     * <p>
     * {@link TreeSet#ceiling(Object)} 记住这个 api ,比你自己写的二分法查快
     *
     * @param args
     */
    public static void main(String[] args) {
        cache.add(4L);
        cache.add(7L);
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        dfs(new ArrayList<Long>() {{
            add(4L);
            add(7L);
        }}, new ArrayList<>(), b);
        long sum = 0;
        // System.out.println("cache = " + cache);
        long left = cache.ceiling((long) a);
        for (int i = a; i <= b; i++) {
            if (i <= left) {
                sum += left;
            } else {
                left = cache.ceiling((long) i);
                sum += left;
            }
        }
        System.out.println(sum);

    }

    public static void dfs(List<Long> prev, List<Long> curr, int b) {
        if (prev.get(prev.size() - 1) >= b) {
            return;
        }
        int[] d = new int[]{4, 7};
        for (int k : d) {
            for (Long integer : prev) {
                long c = Long.parseLong("" + k + integer);
                if (c >= b) {
                    curr.add(c);
                    cache.addAll(curr);
                    return;
                }
                curr.add(c);

            }
        }
        cache.addAll(curr);
        dfs(curr, new ArrayList<>(), b);
    }

}
