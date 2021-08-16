package 第254场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/16 10:41
 * @since 1.0
 **/
public class No1967 {

    /**
     * 作为子字符串出现在单词中的字符串数目
     *
     * @param patterns
     * @param word
     * @return
     */
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                ans++;
            }
        }
        return ans;
    }
}
