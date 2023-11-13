package 深度优先搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/12/28 09:59
 * @since 1.0
 **/
public class No472 {


    Trie trie;
    boolean flag;
    int cnt;

    /**
     * 连接词
     *
     * @param words
     * @return
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        List<String> ans = new ArrayList<>();
        this.trie = new Trie();
        for (String word : words) {
            this.flag = false;
            this.cnt = 0;
            dfs(word, 0);
            if (flag && cnt > 1) {
                ans.add(word);
            } else {
                insert(word);
            }
        }
        return ans;
    }

    public void dfs(String word, int nxt) {
        if (nxt == word.length()) {
            flag = true;
        }
        Trie tmp = trie;
        for (int j = nxt; j < word.length(); j++) {
            if (tmp.nxt[word.charAt(j) - 'a'] != null) {
                tmp = tmp.nxt[word.charAt(j) - 'a'];
                if (tmp.isEnd) {
                    cnt++;
                    dfs(word, j + 1);
                }
            } else {
                break;
            }
        }

    }


    public void insert(String word) {
        Trie curr = trie;
        for (int i = 0; i < word.length(); i++) {
            if (curr.nxt[word.charAt(i) - 'a'] == null) {
                curr.nxt[word.charAt(i) - 'a'] = new Trie();
            }
            curr = curr.nxt[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }

    public static class Trie {

        boolean isEnd;
        Trie[] nxt;

        public Trie() {
            this.isEnd = false;
            this.nxt = new Trie[26];
        }

    }
}
