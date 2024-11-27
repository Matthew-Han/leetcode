/**
 * @ClassName ConvertInteger
 * @Description 面试题 05.06. 整数转换
 * @Author MatthewHan
 * @Date 2020/7/27 14:26
 * @Version 1.0
 **/
public class M0506 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public static int convertInteger(int a, int b) {
        String binaryA = toBin(a);
        String binaryB = toBin(b);
        int count = 0;
        for (int i = 0; i < binaryA.length(); i++) {
            if (binaryA.charAt(i) != binaryB.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static String toBin(int num) {
        char[] chs = new char[Integer.SIZE];
        for (int i = 0; i < Integer.SIZE; i++) {
            chs[Integer.SIZE - 1 - i] = (char) ((num >> i & 1) + '0');
        }
        return new String(chs);
    }
}
