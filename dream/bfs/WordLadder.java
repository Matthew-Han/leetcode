package bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/5 14:39
 **/
public class WordLadder {


    /**
     * #127 单词接龙
     * 执行用时： 883 ms , 在所有 Java 提交中击败了 23.33% 的用户
     * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 97.31% 的用户
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthMain(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean[] vis = new boolean[wordList.size()];
        int ans = 1;
        while (!queue.isEmpty()) {
            int limit = queue.size();
            for (int i = 0; i < limit; i++) {
                String curr = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    String target = wordList.get(j);
                    if (!vis[j] && match(curr, target)) {
                        if (target.equals(endWord)) {
                            return ans + 1;
                        }
                        queue.offer(target);
                        vis[j] = true;
                    }
                }
            }
            ans++;
        }
        return 0;
    }


    int ans = Integer.MAX_VALUE;

    /**
     * 超出时间限制
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] vis = new boolean[wordList.size()];
        dfs(beginWord, endWord, vis, wordList, 1);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public void dfs(String curr, String target, boolean[] vis, List<String> wordList, int step) {
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (!vis[i] && match(curr, word)) {
                boolean[] next = new boolean[vis.length];
                System.arraycopy(vis, 0, next, 0, vis.length);
                next[i] = true;
                if (target.equals(word)) {
                    ans = Math.min(step + 1, ans);
                    return;
                } else {
                    dfs(word, target, next, wordList, step + 1);
                }
            }
        }
    }

    public boolean match(String currWord, String targetWord) {
        int diff = 0;
        for (int i = 0; i < currWord.length(); i++) {
            diff += currWord.charAt(i) == targetWord.charAt(i) ? 0 : 1;
        }
        return diff == 1;
    }
}
