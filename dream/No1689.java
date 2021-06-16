import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/14 14:53
 **/
public class No1689 {


    /**
     * #1689 十-二进制数的最少数目
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 42.22% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 12.53% 的用户
     *
     * @param n
     * @return
     */
    public int minPartitions(String n) {
        int ans = 1;
        for (int i = 0; i < n.length(); i++) {
            ans = Math.max(ans, n.charAt(i) - '0');
        }
        return ans;
    }
}
