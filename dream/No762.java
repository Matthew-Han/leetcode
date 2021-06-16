import java.util.Arrays;

/**
 * @ClassName PrimeNumberOfSetBitsInBinaryRepresentation
 * @Description #762 二进制表示中质数个计算置位
 * @Author MatthewHan
 * @Date 2020/6/16 14:32
 * @Version 1.0
 **/
public class No762 {

    /**
     * 执行用时 : 84 ms , 在所有 Java 提交中击败了 13.35% 的用户
     * 内存消耗 : 39.5 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param l
     * @param r
     * @return
     */
    public static int countPrimeSetBits(int l, int r) {
        int result = 0;
        while (l <= r) {
            int setBitsNum = 0;
            String hex = Integer.toBinaryString(l);
            char[] temp = hex.toCharArray();
            System.out.println("temp = " + Arrays.toString(temp));
            for (char c : temp) {
                if (c == '1') {
                    setBitsNum++;
                }
            }
            if (isPrimeNumber(setBitsNum)) {
                result++;
            }
            l++;
        }
        return result;
    }

    public static boolean isPrimeNumber(int n) {
        if (n <= 3) {
            return n > 1;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(842, 888));
    }
}
