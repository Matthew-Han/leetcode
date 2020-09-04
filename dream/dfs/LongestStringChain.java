package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName LongestStringChain
 * @Description #1048 最长字符串链
 * @Author MatthewHan
 * @Date 2020/9/4 10:11
 * @Version 1.0
 **/
public class LongestStringChain {

    /**
     * 为什么排序 + max 参数会快一点呢？
     * 因为排序之后，在dfs的for循环里能更快找到符合的条件
     * 执行用时： 260 ms , 在所有 Java 提交中击败了 6.23% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 22.50% 的用户
     *
     * @param words
     * @return
     */
    public static int longestStrChain(String[] words) {
        Arrays.sort(words, new Lsc());
        List<List<String>> res = new ArrayList<>();
        for (String word : words) {
            List<String> list = new ArrayList<>();
            list.add(word);
            dfs(words, word.length(), word, list, res);
        }
        int maxLen = Integer.MIN_VALUE;
        for (List<String> re : res) {
            maxLen = Math.max(maxLen, re.size());
        }
        return maxLen;
    }

    public static void dfs(String[] words, int size, String curr, List<String> list, List<List<String>> res) {
        boolean flag = false;
        for (String word : words) {
            if (word.length() == size + 1 && check(curr, word)) {
                flag = true;
                List<String> next = new ArrayList<>(list);
                next.add(word);
                dfs(words, size + 1, word, next, res);
            }
        }
        // 说明没进入循环，可能长度比当前大1的字符串没有包含当前的
        if (!flag) {
            res.add(list);
        }
    }

    public static boolean check(String curr, String word) {
        int[] bucket = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (i < curr.length()) {
                bucket[curr.charAt(i) - 'a']--;
            }
            bucket[word.charAt(i) - 'a']++;
        }
        for (int j : bucket) {
            if (j < 0) {
                return false;
            }
        }
        return true;
    }

}

class Lsc implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
