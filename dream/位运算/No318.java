package 位运算;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/11/18 12:13
 * @since 1.0
 **/
public class No318 {

    Map<String, Set<Character>> map;

    /**
     * 最大单词长度乘积
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        this.map = new HashMap<>();
        init(words);
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (check(words[i], words[j])) {
                    ans = Math.max(words[i].length() * words[j].length(), ans);
                }
            }
        }
        return ans;
    }

    public void init(String[] words) {
        for (String word : words) {
            map.put(word, new HashSet<>(Arrays.asList(toCharArray(word))));
        }
    }

    public boolean check(String a, String b) {
        Set<Character> v = map.get(a);
        for (int i = 0; i < b.length(); i++) {
            if (v.contains(b.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public Character[] toCharArray(String word) {
        Character[] res = new Character[word.length()];
        for (int i = 0; i < word.length(); i++) {
            res[i] = word.charAt(i);
        }
        return res;
    }
}
