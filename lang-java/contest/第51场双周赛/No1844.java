package 第51场双周赛;

/**
 * @author Matthew Han
 * @description
 * @date 2021/5/2 20:43
 * @since 1.0.0
 **/
public class No1844 {

    /**
     * #1844 将所有数字用字符替换
     *
     * @param s
     * @return
     */
    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            char prev = chars[i - 1];
            chars[i] = (char) (prev + chars[i] - '0');
        }
        return new String(chars);
    }
}
