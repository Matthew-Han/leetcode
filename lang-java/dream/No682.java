import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName BaseballGame
 * @Description #682 棒球比赛
 * @Author MatthewHan
 * @Date 2020/5/24 21:12
 * @Version 1.0
 **/
public class No682 {

    /**
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 36.12% 的用户
     * 内存消耗 : 37.7 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param ops
     * @return
     */
    public static int calPointsPro(String[] ops) {
        if ("C".equals(ops[0]) || "+".equals(ops[0]) || "D".equals(ops[0])) {
            return 0;
        }
        List<String> list = new ArrayList<>(ops.length);
        list.addAll(Arrays.asList(ops).subList(0, ops.length));
        int i = 1;
        for (; i < list.size(); i++) {
            if ("C".equals(list.get(i))) {
                list.remove(i - 1);
                list.remove(i - 1);
                i -= 2;
            }
        }
        if (list.size() >= 2 && "+".equals(list.get(1))) {
            return 0;
        }
        int last = 0;
        int curr = Integer.parseInt(list.get(0));
        int sum = curr;
        for (int j = 1; j < list.size(); j++) {
            int temp;
            if ("D".equals(list.get(j))) {
                temp = curr * 2;
                sum += temp;
            } else if ("+".equals(list.get(j))) {
                temp = last + curr;
                sum += temp;
            } else {
                temp = Integer.parseInt(list.get(j));
                sum += temp;
            }
            last = curr;
            curr = temp;
        }
        return sum;

    }

    /**
     * 执行用时 : 302 ms , 在所有 Java 提交中击败了 5.12% 的用户
     * 内存消耗 : 40.3 MB , 在所有 Java 提交中击败了 25.00% 的用户
     *
     * @param ops
     * @return
     */
    public static int calPoints(String[] ops) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (String op : ops) {
            if ("C".equals(op)) {
                if (list.size() - 1 < 0) {
                    return 0;
                }
                sum -= list.get(list.size() - 1);
                list.remove(list.size() - 1);
            } else if ("D".equals(op)) {
                if (list.size() - 1 < 0) {
                    return 0;
                }
                list.add(list.get(list.size() - 1) * 2);
                sum += list.get(list.size() - 1);
            } else if ("+".equals(op)) {
                if (list.size() - 2 < 0) {
                    return 0;
                }
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                sum += list.get(list.size() - 1);
            } else {
                list.add(Integer.parseInt(op));
                sum += Integer.parseInt(op);
            }
            System.out.println("sum = " + sum);
            System.out.println("list = " + list);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calPointsPro(new String[]{"5", "2", "C", "D", "+"}));
    }
}
