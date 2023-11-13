import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MakeTwoArraysEqualByReversingSubArrays
 * @Description #1460 通过翻转子数组使两个数组相等
 * @Author MatthewHan
 * @Date 2020/7/14 18:15
 * @Version 1.0
 **/
public class No1460 {


    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 88.72% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqualProBucket(int[] target, int[] arr) {
        int[] bucket = new int[1001];

        for (int n : target) {
            bucket[n]++;
        }
        for (int n : arr) {
            bucket[n]--;
            if (bucket[n] < 0) {
                return false;
            }
        }
        for (int value : bucket) {
            if (value != 0) {
                return false;
            }
        }
        return true;

    }

    public boolean canBeEqualPro(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : target) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int value : arr) {
            map2.put(value, map2.getOrDefault(value, 0) + 1);
        }

        return map.equals(map2);
    }

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 77.26% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }


}
