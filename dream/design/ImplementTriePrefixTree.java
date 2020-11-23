package design;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/11/20 17:07
 **/
public class ImplementTriePrefixTree {

    private final Set<String> set;

    /**
     * #208 实现 Trie (前缀树)
     * 执行用时： 352 ms , 在所有 Java 提交中击败了 5.00% 的用户
     * 内存消耗： 46.4 MB , 在所有 Java 提交中击败了 97.86% 的用户
     */
    public ImplementTriePrefixTree() {
        set = new HashSet<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        set.add(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return set.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        for (String curr : set) {
            if (prefix.length() <= curr.length() && startsWith(prefix, curr)) {
                return true;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix, String curr) {
        boolean flag = true;
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != curr.charAt(i)) {
                return false;
            }
        }
        return flag;
    }
}
