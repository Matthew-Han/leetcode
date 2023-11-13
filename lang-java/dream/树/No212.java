package 树;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/16 09:57
 * @since 1.0
 **/
public class No212 {

    List<String> ans;
    Trie root;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    /**
     * 单词搜索 II
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        root = new Trie();
        init(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Trie tmp = root;
                boolean[][] vis = new boolean[board.length][board[0].length];
                vis[i][j] = true;
                dfs(board, i, j, vis, tmp, "" + board[i][j]);
            }
        }
        return ans;
    }


    public void dfs(char[][] board, int x, int y, boolean[][] vis, Trie tmp, String sub) {
        char curr = board[x][y];
        if (null == tmp.next[curr - 'a']) {
            return;
        }
        tmp = tmp.next[curr - 'a'];
        if (tmp.isEnd) {
            // 这样就不用去重了
            tmp.isEnd = false;
            ans.add(sub);
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !vis[newX][newY]) {
                vis[newX][newY] = true;
                dfs(board, newX, newY, vis, tmp, sub + board[newX][newY]);
                vis[newX][newY] = false;
            }
        }
    }


    public void init(String[] words) {
        for (String word : words) {
            char[] arr = word.toCharArray();
            Trie tmp = root;
            for (char c : arr) {
                if (null == tmp.next[c - 'a']) {
                    tmp.next[c - 'a'] = new Trie();
                }
                tmp = tmp.next[c - 'a'];
            }
            tmp.isEnd = true;
        }
    }

    static class Trie {

        public Trie[] next;
        public boolean isEnd;

        public Trie() {
            next = new Trie[26];
        }

        @Override
        public String toString() {
            return "\nTrie{" +
                    ", next=" + Arrays.toString(next) +
                    ", isEnd=" + isEnd +
                    "}\n";
        }
    }

}

