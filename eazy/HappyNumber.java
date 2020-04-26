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
     * 快慢指针实现闭环判断
     * @param n
     * @return
     */
    public static boolean isHappyByFloyd(int n) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(36));
    }
}
