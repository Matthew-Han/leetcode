/**
 * @ClassName PowerOfFour
 * @Description #342 4的幂
 * @Author MatthewHan
 * @Date 2020/5/9 09:38
 * @Version 1.0
 **/
public class No342 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.4 MB , 在所有 Java 提交中击败了 7.69% 的用户
     *
     * @param num
     * @return
     */
    public static boolean isPowerOfFour(int num) {
        while (num / 4 > 0) {
            if (num % 4 == 0) {
                num /= 4;
            } else {
                return false;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(8));
    }
}
