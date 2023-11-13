package 第52场双周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/15 22:11
 * @description
 * @since 1.0.0
 **/
public class No1859 {

    /**
     * #1859 将句子排序
     *
     * @param s
     * @return
     */
    public static String sortSentence(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = s.split(" ");
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.charAt(o1.length() - 1), o2.charAt(o2.length() - 1)));
        for (String str : arr) {
            stringBuilder.append(str, 0, str.length() - 1).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

}
