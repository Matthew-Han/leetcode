package design;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/20 17:08
 **/
class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        this.isEnd = false;
        this.children = new TrieNode[26];
    }

}
public class ImplementTriePrefixTree {

    TrieNode trieNode;

    /**
     * #208 实现 Trie (前缀树)
     * <p>
     * 执行用时： 37 ms , 在所有 Java 提交中击败了 99.72% 的用户
     * 内存消耗： 48.6 MB , 在所有 Java 提交中击败了 55.22% 的用户
     */
    int index;
    boolean init;

    TrieNode root;
    TrieNode tmp;

    /**
     * Initialize your data structure here.
     * 执行用时： 36 ms , 在所有 Java 提交中击败了 99.90% 的用户
     * 内存消耗： 47.8 MB , 在所有 Java 提交中击败了 62.48% 的用户
     */
    public ImplementTriePrefixTree() {
        index = 0;
        init = true;
        root = new TrieNode();
        tmp = root;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (init) {
            tmp = root;
            index = 0;
            init = false;
        }
        if (tmp == null) {
            init = true;
            return;
        }
        char curr = word.charAt(index);
        if (tmp.children[curr - 'a'] == null) {
            tmp.children[curr - 'a'] = new TrieNode();
        }
        tmp = tmp.children[curr - 'a'];
        if (index == word.length() - 1) {
            tmp.isEnd = true;
            // 完成该次递归
            init = true;
            // System.out.println(tmp);
        } else {
            index++;
            insert(word);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (init) {
            tmp = root;
            index = 0;
            init = false;
        }
        if (tmp == null) {
            init = true;
            return false;
        }
        char curr = word.charAt(index);
        if (tmp.children[curr - 'a'] == null) {
            init = true;
            // System.out.println("catch");
            return false;
        }
        if (index == word.length() - 1) {
            if (tmp.children[curr - 'a'].isEnd) {
                init = true;
                return true;
            } else {
                init = true;
                return false;
            }
        } else {
            index++;
            tmp = tmp.children[curr - 'a'];
            return search(word);
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (init) {
            tmp = root;
            index = 0;
            init = false;
        }
        if (tmp == null) {
            init = true;
            return false;
        }
        char curr = prefix.charAt(index);
        if (tmp.children[curr - 'a'] == null) {
            init = true;
            return false;
        }
        if (index == prefix.length() - 1) {
            init = true;
            return true;

        } else {
            index++;
            tmp = tmp.children[curr - 'a'];
            return startsWith(prefix);
        }
    }

}
