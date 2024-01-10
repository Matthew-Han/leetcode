package 深度优先搜索;

import 默认模板.TreeNode;
import 默认模板.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @since 2024/1/9 17:04:04
 **/
public class No2707 {

    TrieNode root;

    int ans;

    int[] mem;

    /**
     * 字符串中的额外字符
     *
     * @param s
     * @param dictionary
     * @return
     */
    public int minExtraChar(String s, String[] dictionary) {
        createdTrie(dictionary);
        mem = new int[s.length()];
        Arrays.fill(mem, 0xc0c0c0c0);
        ans = 0;
        dfs(s, 0, 0);
        return s.length() - ans;
    }

    public void dfs(String s, int idx, int sum) {
        for (int i = idx; i < s.length(); i++) {
            if (mem[i] < sum) {
                mem[i] = sum;
                List<Integer> endIds = check(s, i);
                if (!endIds.isEmpty()) {
                    for (Integer endIdx : endIds) {
                        ans = Math.max(ans, sum + endIdx - i + 1);
                        dfs(s, endIdx + 1, sum + endIdx - i + 1);
                    }
                }
            }

        }
    }

    public List<Integer> check(String s, int idx) {
        List<Integer> ans = new ArrayList<>();
        TrieNode curr = root;
        for (int i = idx; i < s.length(); i++) {
            if (curr.next[s.charAt(i) - 'a'] != null) {
                if (curr.next[s.charAt(i) - 'a'].isEnd) {
                    ans.add(i);
                }
                curr = curr.next[s.charAt(i) - 'a'];
            } else {
                break;
            }
        }
        return ans;
    }


    public void createdTrie(String[] dictionary) {
        root = new TrieNode();
        for (String d : dictionary) {
            TrieNode curr = root;
            for (char c : d.toCharArray()) {
                if (curr.next[c - 'a'] == null) {
                    curr.next[c - 'a'] = new TrieNode();
                }
                curr = curr.next[c - 'a'];
            }
            curr.isEnd = true;
        }
    }
}
