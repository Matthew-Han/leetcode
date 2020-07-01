import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName FindTheTownJudge
 * @Description #997 找到小镇的法官
 * @Author MatthewHan
 * @Date 2020/7/1 09:03
 * @Version 1.0
 **/
public class FindTheTownJudge {

    /**
     * 执行用时： 24 ms , 在所有 Java 提交中击败了 13.66% 的用户
     * 内存消耗： 47.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @param trust
     * @return
     */
    public static int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] ints : trust) {
            map.put(ints[1], map.getOrDefault(ints[1], 0) + 1);
            set.add(ints[0]);
        }
        int src = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n - 1) {
                src = entry.getKey();
            }
        }
        if (src == -1) {
            return -1;
        }
        if (set.contains(src)) {
            return -1;
        } else {
            return src;
        }
    }

    public static void main(String[] args) {

    }
}
