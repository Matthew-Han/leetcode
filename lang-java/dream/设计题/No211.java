package 设计题;

import 默认模板.TrieNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/20 16:32
 * @since 1.0
 **/
public class No211 {


    Map<Integer, TrieNode> data;

    /**
     * 添加与搜索单词 - 数据结构设计
     */
    public No211() {
        data = new HashMap<>();
    }

    public void addWord(String word) {
        TrieNode defaultTrie = data.getOrDefault(word.length(), new TrieNode());
        TrieNode finals = defaultTrie;
        for (char c : word.toCharArray()) {
            if (defaultTrie.next[c - 'a'] == null) {
                defaultTrie.next[c - 'a'] = new TrieNode();
            }
            defaultTrie = defaultTrie.next[c - 'a'];
        }
        defaultTrie.isEnd = true;
        data.put(word.length(), finals);
    }

    public boolean search(String word) {
        TrieNode v = data.get(word.length());
        if (v == null) {
            return false;
        }
        return dfs(v, word, 0);
    }


    public boolean dfs(TrieNode trie, String word, int idx) {
        if (trie == null) {
            return false;
        }
        if (idx == word.length()) {
            return trie.isEnd;
        }
        if (word.charAt(idx) == '.') {
            boolean flag = false;
            for (int i = 0; i < 26; i++) {
                flag = flag || dfs(trie.next[i], word, idx + 1);
            }
            return flag;

        } else {
            return dfs(trie.next[word.charAt(idx) - 'a'], word, idx + 1);
        }
    }




}
