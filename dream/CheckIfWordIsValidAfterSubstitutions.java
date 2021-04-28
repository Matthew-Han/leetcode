/**
 * @author Matthew Han
 * @description
 * @date 2021/4/28 11:28
 * @since 1.0.0
 **/
public class CheckIfWordIsValidAfterSubstitutions {


    /**
     * #1003 检查替换后的词是否有效
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 87.59% 的用户
     * 内存消耗： 39.2 MB , 在所有 Java 提交中击败了 8.27% 的用户
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int len = s.length();
        while (true) {
            if (len == 0) {
                return true;
            }
            s = s.replace("abc", "");
            if (s.length() == len) {
                return false;
            }
            len = s.length();
        }

    }
}
