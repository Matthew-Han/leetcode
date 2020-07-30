/**
 * @ClassName BinaryNumberWithAlternatingBits
 * @Description #693 交替位二进制数
 * @Author MatthewHan
 * @Date 2020/5/27 09:41
 * @Version 1.0
 **/
public class BinaryNumberWithAlternatingBits {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 35.24% 的用户
     * 内存消耗 : 36.1 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param n
     * @return
     */
    public static boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        for (int i = 0, j = 1; j < str.length(); i++, j++) {
            if (str.charAt(i) == str.charAt(j)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {

    }


}
