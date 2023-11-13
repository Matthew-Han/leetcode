package 第53场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/29 22:27
 * @description
 * @since 1.0.0
 **/
public class No1876 {

    /**
     * #1876 长度为三且各字符不同的子字符串
     *
     * @param s
     * @return
     */
    public static int countGoodSubstrings(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 3; i += 3) {
            if (chars[i] != chars[i + 1] && chars[i] != chars[i + 2] && chars[i + 1] != chars[i + 2]) {
                ans++;
            }
        }
        return ans;
    }

}
