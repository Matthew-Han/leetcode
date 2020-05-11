package 二分法;

/**
 * @ClassName GuessNumberHigherOrLower
 * @Description #374 猜数字大小
 * @Author MatthewHan
 * @Date 2020/5/11 15:45
 * @Version 1.0
 **/
public class GuessNumberHigherOrLower {

    /**
     * 模拟一个基准数
     *
     * @param n
     * @return
     */
    public static int guess(int n) {
        int point = 6;
        if (point < n) {
            return -1;
        } else if (point == n) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36.4 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param n
     * @return
     */
    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("left: " + left);
            System.out.println("right: " + right);
            if (guess(mid) == 1) {
                left = mid + 1;
            } else if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
