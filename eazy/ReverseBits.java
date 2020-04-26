/**
 * @ClassName ReverseBits
 * @Description #190 颠倒二进制位
 * @Author MatthewHan
 * @Date 2020/4/24 16:45
 * @Version 1.0
 **/
public class ReverseBits {

    /**
     * you need treat n as an unsigned value
     * 关键核心是补全到32位
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        // 将int转化为二进制字符串
        String binaryString = Integer.toBinaryString(n);
        int length = binaryString.length();
        StringBuilder sb = new StringBuilder();
        // 对不够32位的二进制进行补齐
        if (length < 32) {
            int dis = 32 - length;
            for (int i = 0; i < dis; i++) {
                sb.append('0');
            }
        }
        // 获取32位的二进制字符串
        sb.append(binaryString);
        // 将二进制字符串反转
        String result = sb.reverse().toString();
        return Integer.parseUnsignedInt(result, 2);
    }


    public static void main(String[] args) {
        System.out.println("reverseBits(2) = " + reverseBits(-10));
    }
}
