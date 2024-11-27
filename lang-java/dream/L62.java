import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LcOf62
 * @Description 剑指 Offer #62 圆圈中最后剩下的数字
 * @Author MatthewHan
 * @Date 2020/7/22 10:53
 * @Version 1.0
 **/
public class L62 {


    /**
     * 用 LinkedList 超出时间限制，无语
     * <p>
     * 执行用时： 1062 ms , 在所有 Java 提交中击败了 26.74% 的用户
     * 内存消耗： 41.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = m - 1;
        while (list.size() > 1) {
            if (index > list.size() - 1) {
                index %= list.size();
            }
            System.out.println("index = " + index);
            System.out.println("list = " + list);
            list.remove(index);
            index += m - 1;
        }
        return list.getFirst();

    }
}
