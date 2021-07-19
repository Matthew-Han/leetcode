package 第250场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/19 09:19
 * @since 1.0
 **/
public class No1935 {

    /**
     * 可以输入的最大单词数
     *
     * @param text
     * @param brokenLetters
     * @return
     */
    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        String[] strs = text.split(" ");
        for (String str : strs) {
            boolean flag = true;
            for (char c : str.toCharArray()) {
                if (brokenLetters.indexOf(c) != -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }

        }
        return ans;
    }

}
