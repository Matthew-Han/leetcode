package 第234场周赛;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/29 09:07
 **/
public class EvaluateTheBracketPairsOfaString {

    /**
     * #1807 替换字符串中的括号内容
     * 执行用时： 52 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 77.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s
     * @param knowledge
     * @return
     */
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> cache = new HashMap<>();
        for (List<String> k : knowledge) {
            cache.put(k.get(0), k.get(1));
        }
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                flag = false;
                continue;
            }
            if (s.charAt(i) == ')') {
                flag = true;
            }
            if (!flag) {
                sb.append(s.charAt(i));
            } else {
                ans.append(s.charAt(i));
            }
            if (flag && sb.length() > 0) {
                // System.out.println(sb.toString());
                ans.deleteCharAt(ans.length() - 1);
                String k = sb.toString();
                ans.append(cache.get(k) == null ? "?" : cache.get(k));
                sb.setLength(0);
            }
        }
        return ans.toString();
    }
}
