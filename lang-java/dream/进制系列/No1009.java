package 进制系列;

/**
 * @ClassName 进制系列.ComplementOfBaseTenInteger
 * @Description #1009 十进制整数的反码
 * @Author MatthewHan
 * @Date 2020/7/1 14:47
 * @Version 1.0
 **/
public class No1009 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 8.95% 的用户
     * 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int bitwiseComplement(int n) {
        String fucker = Integer.toBinaryString(n);
        StringBuilder gg = new StringBuilder();
        System.out.println(fucker);
        for (int i = 0; i < fucker.length(); i++) {
            gg.append(Integer.parseInt(String.valueOf(fucker.charAt(i))) ^ 1);
        }
        return Integer.valueOf(gg.toString(), 2);
    }

    /**
     * 6 是 110
     * 110 的反码是与 111 异或得到的 001
     * 所以找到比 N 大的每位都为1的数，与 n 进行异或。
     *
     * @param n
     * @return
     */
    public static int bitwiseComplementPro(int n) {
        int num = 1;
        while (num < n) {
            num = (num << 1) + 1;
        }
        return n ^ num;
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplementPro(5));
    }


}
