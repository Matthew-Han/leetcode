package 第245场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 15:20
 * @description
 * @since 1.0.0
 **/
public class No1897 {

    /**
     * #1897 重新分配字符使所有字符串都相等
     *
     * @param words
     * @return
     */
    public boolean makeEqual(String[] words) {
        if (words.length == 1) {
            return true;
        }
        int[] bucket = new int[26];
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                bucket[s.charAt(i) - 'a']++;
            }
        }
        for (int j : bucket) {
            if (j > 0) {
                if (j % words.length != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
