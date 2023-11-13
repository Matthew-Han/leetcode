/**
 * @ClassName ToLowerCase
 * @Description #709 转换成小写字母
 * @Author MatthewHan
 * @Date 2020/6/1 17:21
 * @Version 1.0
 **/
public class No709 {

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.4 MB , 在所有 Java 提交中击败了 5.88% 的用户
     *
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                stringBuilder.append((char) (str.charAt(i) + 32));
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(toLowerCase("LOveRsD"));

    }
}
