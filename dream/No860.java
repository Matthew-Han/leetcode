import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LemonadeChange
 * @Description #860 柠檬水找零
 * @Author MatthewHan
 * @Date 2020/6/20 21:01
 * @Version 1.0
 **/
public class No860 {

    /**
     * 执行用时 : 83 ms , 在所有 Java 提交中击败了 5.63% 的用户
     * 内存消耗 : 41 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {

        List<Integer> list = new ArrayList<>();
        for (int bill : bills) {
            if (bill == 5) {
                list.add(5);
            } else if (bill == 10) {
                boolean fuck = list.remove((Object) 5);
                if (!fuck) {
                    return false;
                } else {
                    list.add(10);
                }
            } else {
                // 这里要先判断10，不能先判断5，不然为false还要在重新加回来
                boolean condition1 = list.remove((Object) 10) && list.remove((Object) 5);
                System.out.println(list);
                if (!condition1) {
                    boolean condition2 = list.remove((Object) 5) && list.remove((Object) 5) && list.remove((Object) 5);
                    if (!condition2) {
                        return false;
                    }
                }
            }

        }
        System.out.println("list = " + list);
        return true;
    }

    /**
     * 执行用时 : 26 ms , 在所有 Java 提交中击败了 5.63% 的用户
     * 内存消耗 : 41.1 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param bills
     * @return
     */
    public static boolean lemonadeChangePro(int[] bills) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            if (bill == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bill == 10) {
                map.put(5, (map.get(5) == null ? 0 : map.get(5)) - 1);
                if (map.get(5) < 0) {
                    return false;
                } else {
                    map.put(10, map.getOrDefault(10, 0) + 1);
                }
            } else {
                boolean condition1 = (map.get(5) == null ? 0 : map.get(5)) - 1 >= 0 && (map.get(10) == null ? 0 : map.get(10)) - 1 >= 0;
                if (!condition1) {
                    map.put(5, (map.get(5) == null ? 0 : map.get(5)) - 3);
                    if (map.get(5) < 0) {
                        return false;
                    }
                } else {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) - 1);
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChangePro(new int[]{5, 5, 5, 20}));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        boolean xx = list.remove((Object) 1);
        if (xx) {
            System.out.println(list);
        }
        System.out.println(list);


    }
}
