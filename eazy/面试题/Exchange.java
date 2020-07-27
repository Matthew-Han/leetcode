package 面试题;

/**
 * @ClassName Exchange
 * @Description 面试题 05.07. 配对交换
 * @Author MatthewHan
 * @Date 2020/7/27 14:37
 * @Version 1.0
 **/
public class Exchange {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 7.30% 的用户
     * 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param num
     * @return
     */
    public int exchangeBits(int num) {
        String binary = Integer.toBinaryString(num);
        if ((binary.length() & 1) != 0) {
            binary = "0" + binary;
        }
        char[] chars = binary.toCharArray();
        for (int i = 0; i < chars.length; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }
        return Integer.valueOf(new String(chars), 2);
    }

}
