package 贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName ReduceArraySizeToTheHalf
 * @Description #1338 数组大小减半
 * @Author MatthewHan
 * @Date 2020/8/31 09:41
 * @Version 1.0
 **/
public class No1338 {

    /**
     * 执行用时： 17 ms , 在所有 Java 提交中击败了 94.35% 的用户
     * 内存消耗： 49.5 MB , 在所有 Java 提交中击败了 69.75% 的用户
     *
     * @param arr
     * @return
     */
    public int minSetSize(int[] arr) {
        int len = arr.length;
        int[] bucket = new int[100001];
        for (int j : arr) {
            bucket[j]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int n : bucket) {
            if (n > 0) {
                list.add(n);
            }
        }
        Collections.sort(list);
        System.out.println("list = " + list);
        int count = 0;
        int tmp = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            count++;
            tmp += list.get(i);
            if (tmp >= len / 2) {
                return count;
            }
        }
        return -1;
    }
}
