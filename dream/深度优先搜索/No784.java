package 深度优先搜索;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/10/28 17:26
 **/
public class No784 {

    /**
     * #784 字母大小写全排列
     * <p>
     * 执行用时： 90 ms , 在所有 Java 提交中击败了 5.00% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 25.40% 的用户
     *
     * @param s
     * @return
     */
    public List<String> letterCasePermutation(String s) {
        Set<String> res = new HashSet<>();
        StringBuilder newStr = new StringBuilder();
        int diff = 'a' - 'A';
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isUpperCase(curr)) {
                curr += diff;
            }
            newStr.append(curr);
        }
        dfs(newStr.toString(), res, 0);
        res.add(s);
        return new ArrayList<>(res);
    }

    public void dfs(String s, Set<String> set, int index) {
        for (int i = index; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                String str2 = toUpper(s, i);
                set.add(s);
                set.add(str2);
                dfs(s, set, i + 1);
                dfs(str2, set, i + 1);
            }
        }
    }

    public String toUpper(String s, int i) {
        char[] tmp = s.toCharArray();
        tmp[i] -= 'a' - 'A';
        return String.valueOf(tmp);
    }

}
