package 位运算;

/**
 * @ClassName 位运算.BinaryNumberWithAlternatingBits
 * @Description #693 交替位二进制数
 * @Author MatthewHan
 * @Date 2020/5/27 09:41
 * @Version 1.0
 **/
public class No693 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 35.24% 的用户
     * 内存消耗 : 36.1 MB , 在所有 Java 提交中击败了 14.29% 的用户
     *
     * @param n
     * @return
     */
    public static boolean hasAlternatingBits(int n) {
        while (n > 0) {
            if ((n >> 1 & 1) == (n & 1)) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }


}
