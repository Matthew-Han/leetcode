package 设计题;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/11/15 12:23
 * @since 1.0
 **/
public class No677 {

    Map<String, Integer> cache;
    Trie trie;

    /**
     * 键值映射
     */
    public No677() {
        cache = new HashMap<>();
        trie = new Trie(-1);
    }

    public void insert(String key, int val) {
        insert(key, cache.getOrDefault(key, 0), val, trie);
        cache.put(key, val);
    }

    public void insert(String key, int oldVal, int newVal, Trie trie) {
        Trie tmp = trie;
        for (int i = 0; i < key.length(); i++) {
            if (tmp.next[key.charAt(i) - 'a'] == null) {
                tmp.next[key.charAt(i) - 'a'] = new Trie(newVal);
            } else {
                tmp.next[key.charAt(i) - 'a'].val += newVal - oldVal;
            }
            tmp = tmp.next[key.charAt(i) - 'a'];
        }

    }

    public int sum(String prefix) {
        Trie tmp = trie;
        for (int i = 0; i < prefix.length(); i++) {
            if (tmp.next[prefix.charAt(i) - 'a'] == null) {
                return 0;
            } else {
                tmp = tmp.next[prefix.charAt(i) - 'a'];
            }
        }
        return tmp == null ? 0 : tmp.val;
    }


    public static class Trie {

        Trie[] next;
        int val;

        public Trie(int val) {
            this.val = val;
            this.next = new Trie[26];
        }
    }
}
