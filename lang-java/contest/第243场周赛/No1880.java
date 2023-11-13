package 第243场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/30 22:29
 * @description
 * @since 1.0.0
 **/
public class No1880 {

    /**
     * #1880 检查某单词是否等于两单词之和
     *
     * @param firstWord
     * @param secondWord
     * @param targetWord
     * @return
     */
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return processor(firstWord) + processor(secondWord) == processor(targetWord);
    }

    public int processor(String curr) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curr.length(); i++) {
            sb.append(curr.charAt(i) - 'a');
        }
        return Integer.parseInt(sb.toString());
    }
}
