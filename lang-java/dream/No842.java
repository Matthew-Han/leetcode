import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/12/9 08:54
 **/
public class No842 {

    List<Integer> ans = Collections.emptyList();

    /**
     * #842 将数组拆分成斐波那契序列
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 70.55% 的用户
     * 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 82.34% 的用户
     *
     * @param s
     * @return
     */
    public List<Integer> splitIntoFibonacci(String s) {
        int len = s.length();

        for (int i = 0; i < len; i++) {
            String sub1 = s.substring(0, i + 1);
            if (check(sub1)) {
                break;
            }
            List<Integer> res = new ArrayList<>();
            res.add(Integer.parseInt(sub1));
            for (int j = i + 1; j < len; j++) {

                String sub2 = s.substring(i + 1, j + 1);
                if (check(sub2)) {
                    break;
                }
                List<Integer> next = new ArrayList<>(res);
                next.add(Integer.parseInt(sub2));
                //System.out.println("next: " + next);
                dfs(s, sub1, sub2, j + 1, next);
            }
        }
        return ans;
    }

    public void dfs(String s, String sub1, String sub2, int index, List<Integer> res) {
        if (res == null) {
            return;
        }
        if (index == s.length() && res.size() > 2) {
            // 只保证第一次赋值
            if (ans.isEmpty()) {
                ans = res;
            }
            return;
        }
        int len = Math.max(sub1.length(), sub2.length());
        long total = Integer.parseInt(sub1) + Integer.parseInt(sub2);
        // System.out.println("total: " + total);
        if (index + len > s.length()) {
            res = null;
            return;
        }
        String tmp1 = s.substring(index, index + len);
        if (check(tmp1)) {
            return;
        }
        // System.out.println("tmp1: " + tmp1);
        int curr1 = Integer.parseInt(tmp1);

        if (curr1 == total) {
            res.add(curr1);
            // System.out.println("res1: " + res);
            // System.out.println("index1: " + (index + len));
            dfs(s, sub2, tmp1, index + len, res);
        } else {
            if (index + len + 1 > s.length()) {
                return;
            }
            String tmp2 = s.substring(index, index + len + 1);
            if (check(tmp2)) {
                return;
            }
            long curr2 = Long.parseLong(tmp2);
            if (curr2 <= Integer.MAX_VALUE && curr2 == total) {
                res.add((int) curr2);
                // System.out.println("res2: " + res);
                // System.out.println("index2: " + (index + len + 1));
                dfs(s, sub2, tmp2, index + len + 1, res);
            } else {
                res = null;
            }
        }

    }

    /**
     * 检查是否溢出或者头元素为0
     */
    public boolean check(String sb) {
        long tmp = Long.parseLong(sb);
        return tmp > Integer.MAX_VALUE || sb.charAt(0) == '0' && sb.length() > 1;
    }
}
