package 进制系列;

/**
 * @ClassName 进制系列.ConvertAnumberToHexadecimal
 * @Description #405 数字转换为十六进制数
 * @Author MatthewHan
 * @Date 2020/5/14 09:16
 * @Version 1.0
 **/
public class No405 {

    /**
     * 负整数在 java 中是以补码的形式存储
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 56.04% 的用户
     * 内存消耗 : 37.2 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param num
     * @return
     */
    public static String toHex(int num) {

        StringBuilder hex = new StringBuilder();
        if (num > 0) {
            while (num > 0) {
                String temp = (num % 16) > 9 ? String.valueOf((char) (num % 16 + 87)) : String.valueOf(num % 16);
                hex.append(temp);
                num /= 16;
            }
        } else if (num == 0) {
            return "0";
        } else {
            String binary = Integer.toBinaryString(num);

            int start = binary.length() - 4;
            int end = binary.length();

            while (start >= 0) {
                // 截取二进制补码的每4位
                int decimal = Integer.parseInt(binary.substring(start, end), 2);
                // 4 位二进制的补码转成 10 进制再转成 16 进制（因为最大是 1111，也就是 16 也就是 f）
                String temp = decimal > 9 ? String.valueOf((char) (decimal + 87)) : String.valueOf(decimal);
                hex.append(temp);

                start -= 4;
                end -= 4;
            }
        }
        return hex.reverse().toString();
    }


    /**
     * 位移计算无符号的二进制
     *
     * @param num
     * @return
     */
    public static String toHexPro(int num) {

        char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            // 使用位与
            sb.append(array[num & 15]);
            // 无符号右移，左边填0
            num = num >>> 4;
        }
        return sb.reverse().toString();

    }


    public static void main(String[] args) {
        System.out.println(toHex(78785));
        System.out.println(Integer.toHexString(78785));

        String binary = Integer.toBinaryString(33);
        System.out.println(binary);
    }
}
