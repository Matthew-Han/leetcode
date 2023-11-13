/**
 * @ClassName PowerOfTwo
 * @Description #231 2的幂
 * @Author MatthewHan
 * @Date 2020/4/29 15:10
 * @Version 1.0
 **/
public class No231 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.1 MB , 在所有 Java 提交中击败了 6.90% 的用户
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0 || n <= 0) {
            return false;
        } else {
            while (n > 1) {
                if (n % 2 != 0) {
                    return false;
                }
                n /= 2;
            }
            return true;
        }
    }

    /**
     * 简化版
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37 MB , 在所有 Java 提交中击败了 6.90% 的用户
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwoPro(int n) {
        while (n / 2 > 0) {
            System.out.println(n);
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return n == 1;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfTwoPro(2));
        System.out.println(3 >> 1);

    }
}
