/**
 * @ClassName LicenseKeyFormatting
 * @Description #482 密钥格式化
 * @Author MatthewHan
 * @Date 2020/5/17 21:01
 * @Version 1.0
 **/
public class No482 {

    /**
     * 1. 取得第一个分组的长度很关键；
     * 2. 是去掉`-`的字符串的长度除以K的余数，如果是0则第一组的长度就是K，不然就是余数；
     * 3. 知道第一组的长度之后就很好办辣。
     * 执行用时 : 18 ms , 在所有 Java 提交中击败了 60.39% 的用户
     * 内存消耗 : 40.8 MB , 在所有 Java 提交中击败了 12.50% 的用户
     *
     * @param S
     * @param K
     * @return
     */
    public static String licenseKeyFormatting(String S, int K) {
        String key = S.replaceAll("-", "").toUpperCase();
        if (S.length() <= K) {
            return key;
        }
        int headLen = (key.length() % K) == 0 ? K : key.length() % K;
        StringBuilder sb = new StringBuilder();
        sb.append(key, 0, headLen);
        int start = headLen;
        int end = start + K;
        while (start <= key.length() - headLen) {
            sb.append("-").append(key, start, end);
            start += K;
            end = start + K;
        }
        return sb.toString();
    }
}
