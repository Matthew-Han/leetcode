/**
 * @ClassName DetectCapital
 * @Description #520 检测大写字母
 * @Author MatthewHan
 * @Date 2020/5/20 09:26
 * @Version 1.0
 **/
public class No520 {

    /**
     * 2021.11.15
     *
     * @param word
     * @return
     */
    public boolean date2021115(String word) {
        boolean head = Character.isUpperCase(word.charAt(0));
        int cnt = head ? 1 : 0;
        for (int i = 1; i < word.length(); i++) {
            cnt += Character.isUpperCase(word.charAt(i)) ? 1 : 0;
        }
        return head ? (cnt == 1 || cnt == word.length()) : cnt == 0;
    }

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
        for (int i = 0; i < word.length(); i++) {
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
}
