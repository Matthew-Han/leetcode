import sun.jvm.hotspot.memory.PlaceholderEntry;
import java.util.Arrays;

/**
 * @ClassName DetectCapital
 * @Description #520 检测大写字母
 * @Author MatthewHan
 * @Date 2020/5/20 09:26
 * @Version 1.0
 **/
public class DetectCapital {

    /**
     * 数组流
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 38.3 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param word
     * @return
     */
    public static boolean detectCapitalUseByArray(String word) {
        int count = 0;
        for (int i = 0; i < word.toCharArray().length; i++) {
            count += word.charAt(i) <= 90 ? 1 : 0;
        }
        if (count == word.length()) {
            return true;
        } else if (count == 0) {
            return true;
        } else {
            return word.charAt(0) <= 90 && count == 1;
        }
    }


    /**
     * 逻辑判断流
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 38.7 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param word
     * @return
     */
    public static boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        char[] chars = word.toCharArray();
        // 首位小写为true
        boolean firstIsCapital = chars[0] <= 122 && chars[0] >= 97;
        if (firstIsCapital) {
            for (int i = 0; i < chars.length; i++) {
                // 首位小写时，其它位大写就GG啦！
                if (i != 0 && chars[i] <= 90) {
                    return false;
                }
            }
        } else {
            // 当首位大写时判断其它位是否全是大写字母或者全是小写字母，不然也false
            boolean qdx = true;
            boolean qxx = true;
            for (int i = 0; i < chars.length; i++) {
                // 全部大写
                if (i != 0 && chars[i] < 97) {
                    qdx = false;
                }
                // 全小写
                if (i != 0 && chars[i] > 90) {
                    qxx = false;
                }
            }
            return (qdx || qxx);
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(detectCapitalUseByArray("EALE"));
    }
}
