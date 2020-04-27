import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName HappyNumber
 * @Description #202 快乐数
 * @Author MatthewHan
 * @Date 2020/4/26 16:23
 * @Version 1.0
 **/
public class HappyNumber {

    /**
     * 超过内存限制
     *
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {

        // 使用hashSet查找比列表和数组快
        HashSet<Integer> set = new HashSet<>(n);
        while (true) {
            int temp = 0;
            // int值搞循环一般利用取余
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                temp += d * d;
            }
            if (set.contains(temp)) {
                return false;
            }
            if (temp == 1) {
                return true;
            }
            set.add(temp);
            n = temp;
            System.out.println(n);
        }

    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.89% 的用户
     * 内存消耗 : 36.8 MB , 在所有 Java 提交中击败了 8.33% 的用户
     * 快慢指针实现闭环判断
     *
     * @param n
     * @return
     */
    public static boolean isHappyByFloyd(int n) {
        int quick = n;
        int slow = n;
        do {
            // 快指针，每次取模计算两次
            quick = backNumber(backNumber(quick));
            // 慢指针，每次取模计算一次
            slow = backNumber(slow);
            if (quick == 1 || slow == 1) {
                return true;
            }

        } while (quick != slow);
        return false;
    }

    public static int backNumber(int n) {
        int r = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            r += d * d;
        }
        System.out.println("r = " + r);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(isHappyByFloyd(19));
    }
}
