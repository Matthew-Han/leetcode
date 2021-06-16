import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SelfDividingNumbers
 * @Description #728 自除数
 * @Author MatthewHan
 * @Date 2020/6/5 16:57
 * @Version 1.0
 **/
public class No728 {

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 99.38% 的用户
     * 内存消耗 : 37.4 MB , 在所有 Java 提交中击败了 20.00% 的用户
     *
     * @param left
     * @param right
     * @return
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>(right - left + 1);
        for (int i = left; i <= right; i++) {
            if (fuck(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean fuck(int i) {
        int temp = i;
        while (i > 0) {
            if (i % 10 == 0) {
                return false;
            }
            if (temp % (i % 10) != 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }
}
