import java.util.HashSet;
import java.util.Set;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/29 09:03
 **/
public class NumberOfDifferentIntegersInAstring {

    /**
     * #5713 字符串中不同整数的数目
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param word
     * @return
     */
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                sb.append(word.charAt(i));
            } else {
                if (sb.length() > 0) {

                    set.add(processor(sb.toString()));
                }
                sb.setLength(0);
            }
            if (i == word.length() - 1) {
                if (sb.length() > 0) {
                    set.add(processor(sb.toString()));
                }
            }
        }
        // System.out.println(set);
        return set.size();
    }

    public String processor(String sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                return sb.substring(i);
            }
        }
        return "0";
    }
}
