/**
 * @ClassName LengthOfLastWord
 * @Description #58 最后一个单词的长度
 * @Author MatthewHan
 * @Date 2020/4/14 11:18
 * @Version 1.0
 **/
public class No58 {

    /**
     * 这题的通过率很低，但其实很简单。。。
     * 关键是考虑的全部全面，类似平时写代码对bug的control
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        String[] strings = s.split(" ");
        if (strings.length > 0) {
            return strings[strings.length - 1].length();
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("  "));
    }
}
