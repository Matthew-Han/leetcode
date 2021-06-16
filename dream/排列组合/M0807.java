package 排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PermutationI
 * @Description 面试题 08.07. 无重复字符串的排列组合
 * @Author MatthewHan
 * @Date 2020/9/4 17:03
 * @Version 1.0
 **/
public class M0807 {

    /**
     * 执行用时： 25 ms , 在所有 Java 提交中击败了 35.60% 的用户
     * 内存消耗： 47.7 MB , 在所有 Java 提交中击败了 77.02% 的用户
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            boolean[] visited = new boolean[s.length()];
            visited[i] = true;
            dfs(s, visited, String.valueOf(s.charAt(i)), res);
        }
        return res.toArray(new String[0]);
    }

    public static void dfs(String s, boolean[] visited, String curr, List<String> res) {
        if (curr.length() == s.length()) {
            res.add(curr);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                // 数组和新字符串要用新的对象
                boolean[] newVisited = new boolean[s.length()];
                System.arraycopy(visited, 0, newVisited, 0, s.length());
                newVisited[i] = true;
                String next = curr + s.charAt(i);
                dfs(s, newVisited, next, res);
            }
        }


    }
}
