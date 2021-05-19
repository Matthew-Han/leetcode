/**
 * @ClassName CheckIfaWordOccursAsaPrefixOfAnyWordInaSentence
 * @Description #1455 检查单词是否为句中其他单词的前缀
 * @Author MatthewHan
 * @Date 2020/7/14 17:42
 * @Version 1.0
 **/
public class No1455 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param sentence
     * @param searchWord
     * @return
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        int len = searchWord.length();
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() >= len) {
                if (strings[i].substring(0, len - 1).equals(searchWord)) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

}
