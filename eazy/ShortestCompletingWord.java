import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName ShortestCompletingWord
 * @Description #748 最短完整词
 * @Author MatthewHan
 * @Date 2020/6/15 17:56
 * @Version 1.0
 **/
public class ShortestCompletingWord {

    /**
     * 执行用时 : 13 ms , 在所有 Java 提交中击败了 28.85% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param licensePlate
     * @param words
     * @return
     */
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.replaceAll(" ", "").replaceAll("[^(A-Za-z)]", "");
        int matchSum = licensePlate.length();
        System.out.println("licensePlate = " + licensePlate);
        System.out.println("licensePlate.length() = " + licensePlate.length());
        List<String> result = new ArrayList<>(words.length);
        for (String word : words) {
            int tempSum = 0;
            char[] wordChar = word.toCharArray();
            for (char c : licensePlate.toCharArray()) {
                for (int i = 0; i < wordChar.length; i++) {
                    if (wordChar[i] == c || wordChar[i] + 32 == c || wordChar[i] - 32 == c) {
                        tempSum++;
                        // 这个元素下次就不能用了
                        wordChar[i] = (char) -1;
                        break;
                    }
                }
            }
            if (matchSum == tempSum) {
                result.add(word);
            }
        }
        System.out.println("result = " + result);
        int min = Integer.MAX_VALUE;
        for (String s : result) {
            min = Math.min(min, s.length());
        }
        for (String s : result) {
            if (s.length() == min) {
                return s;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("AN87005", new String[]{
                "participant", "individual", "start", "exist", "above", "already", "easy", "attack", "player", "important"}));
        System.out.println("===============");
        System.out.println(shortestCompletingWord("1s3 PSt", new String[]{
                "step", "steps", "stripe", "stepple"}));

    }
}
