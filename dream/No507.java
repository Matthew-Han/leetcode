import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName PerfectNumber
 * @Description #507 完美数
 * @Author MatthewHan
 * @Date 2020/5/19 14:18
 * @Version 1.0
 **/
public class No507 {

    /**
     * 该方法超出内存限制
     *
     * @param num
     * @return
     */
    public static boolean checkPerfectNumber(int num) {
        if (num == 1 || num < 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>(num);
        set.add(1);
        int n = 2;
        int end = num;
        while (n < end) {
            System.out.println(n);
            if (num % n == 0) {
                set.add(n);
                set.add(num / n);
                end = num / n;
            }
            n++;
        }
        int count = 0;
        for (Integer integer : set) {
            count += integer;
        }
        System.out.println(set);
        System.out.println(count);
        return num == count;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(20996011));
    }
}
