package 第59场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/23 10:41
 * @since 1.0
 **/
public class No1974 {

    /**
     * 使用特殊打字机键入单词的最少时间
     *
     * @param word
     * @return
     */
    public int minTimeToType(String word) {
        char[] arr = word.toCharArray();
        char index = 'a';
        int ans = 0;
        for (char c : arr) {
            ans += Math.min(Math.abs(c - index), Math.abs(Math.min(c - index, index - c) + 26) % 26) + 1;
            index = c;
        }
        return ans;
    }
}
