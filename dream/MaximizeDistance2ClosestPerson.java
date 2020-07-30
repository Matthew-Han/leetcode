import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MaximizeDistance2ClosestPerson
 * @Description #849 到最近的人的最大距离
 * @Author MatthewHan
 * @Date 2020/6/20 18:17
 * @Version 1.0
 **/
public class MaximizeDistance2ClosestPerson {

    /**
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 21.51% 的用户
     * 内存消耗 : 41.4 MB , 在所有 Java 提交中击败了 11.11% 的用户
     *
     * @param seats
     * @return
     */
    public static int maxDistToClosest(int[] seats) {

        List<Integer> list = new ArrayList<>(seats.length);
        boolean fuck = true;
        int low = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0 && fuck) {
                fuck = false;
                low = i;
            }
            if (seats[i] == 1 && !fuck) {
                fuck = true;
                /*
                 * 如果low == 0，说明最左边是0，则需要 * 2
                 *
                 * 因为题目说了
                 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
                 * 所以可以这么写，不然要判断是都全0
                 */
                list.add(low == 0 ? (i - low) * 2 : i - low);
            }
            // 模拟最后一位补了一个哨兵：1
            if (i == seats.length - 1 && seats[i] == 0) {
                /*
                 * 最后一位是0，一定需要 * 2
                 *
                 * 因为题目说了
                 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
                 * 所以可以这么写，不然要判断是都全0
                 */
                list.add((i - low + 1) * 2);
            }
        }
        System.out.println("list = " + list);

        // 不用Collections.sort方法，因为那个更慢
        int max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            max = Math.max(max, integer);
        }
        System.out.println("max = " + max);
        // 计数要加1，偶数不用
        return max % 2 == 0 ? max / 2 : max / 2 + 1;
    }

    public static void main(String[] args) {

        System.out.println(maxDistToClosest(new int[]{0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0}));
    }
}
