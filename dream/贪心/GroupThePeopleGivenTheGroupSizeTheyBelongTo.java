package 贪心;

import com.sun.org.apache.bcel.internal.generic.NEW;
import java.util.*;

/**
 * @ClassName GroupThePeopleGivenTheGroupSizeTheyBelongTo
 * @Description #1282 用户分组
 * @Author MatthewHan
 * @Date 2020/8/28 18:05
 * @Version 1.0
 **/
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {


    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 64.67% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 48.59% 的用户
     *
     * @param groupSizes
     * @return
     */
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>(groupSizes.length);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> temp = map.get(groupSizes[i]);
            if (temp == null) {
                temp = new ArrayList<>();
            }
            temp.add(i);
            map.put(groupSizes[i], temp);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> value = entry.getValue();
            int count = 0;
            List<Integer> sub = new ArrayList<>(key);
            for (Integer integer : value) {
                sub.add(integer);
                count++;
                if (count == key) {
                    res.add(sub);
                    sub = new ArrayList<>(key);
                    count = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{1}));
        System.out.println(groupThePeople(new int[]{4, 4, 4, 4, 3, 3, 3, 3, 3, 1, 2, 2, 3, 2, 2}));
    }

}
