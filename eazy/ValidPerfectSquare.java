/**
 * @ClassName ValidPerfectSquare
 * @Description #367 有效的完全平方数
 * @Author MatthewHan
 * @Date 2020/5/9 18:01
 * @Version 1.0
 **/
public class ValidPerfectSquare {

    /**
     * 执行用时 : 454 ms , 在所有 Java 提交中击败了 5.12% 的用户
     * 内存消耗 : 36.2 MB , 在所有 Java 提交中击败了 9.52% 的用户
     *
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if (num == 1 || num == 4) {
            return true;
        }
        if (num < 0) {
            return false;
        }
        if (num > 8) {
            int max = num / 3;
            for (int i = 0; i <= max; i++) {
                if (i * i == num) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(Math.sqrt(1024));
    }
}
