import java.util.Arrays;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2020/10/27 16:16
 **/
public class No945 {


    /**
     * #945 使数组唯一的最小增量
     * 执行用时： 1423 ms , 在所有 Java 提交中击败了 5.03% 的用户
     * 内存消耗： 46.3 MB , 在所有 Java 提交中击败了 62.30% 的用户
     *
     * @param a
     * @return
     */
    public int minIncrementForUnique(int[] a) {
        Arrays.sort(a);
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            while (a[i] <= a[i - 1]) {
                a[i] += 1;
                count++;
            }
        }
        return count;
    }
}
