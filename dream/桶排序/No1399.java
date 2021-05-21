package 桶排序;

import java.util.*;

/**
 * @ClassName 桶排序.CountLargestGroup
 * @Description #1399 统计最大组的数目
 * @Author MatthewHan
 * @Date 2020/7/13 16:14
 * @Version 1.0
 **/
public class No1399 {

    public static void main(String[] args) {
        System.out.println(countLargestGroupPro(37));
    }

    /**
     * 经典桶排
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 70.13% 的用户
     * 内存消耗： 36.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int countLargestGroupBucket(int n) {
        int[] bucket = new int[37];
        for (int i = 1; i <= n; i++) {
            int key = getBitSum(i);
            bucket[key]++;
        }
        int max = Integer.MIN_VALUE;
        for (int value : bucket) {
            max = Math.max(max, value);
        }
        int count = 0;
        for (int t : bucket) {
            if (t == max) {
                count++;
            }
        }
        return count;
    }

    /**
     * 执行用时： 23 ms , 在所有 Java 提交中击败了 14.13% 的用户
     * 内存消耗： 37.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int countLargestGroupPro(int n) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            int key = getBitSum(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        System.out.println("map = " + map);
        Collection<Integer> collection = map.values();
        int[] ints = new int[collection.size()];
        int index = 0;
        for (Integer integer : collection) {
            ints[index] = integer;
            index++;
        }
        Arrays.sort(ints);
        int count = 1;
        for (int i = ints.length - 1; i > 0; i--) {
            if (ints[i] == ints[i - 1]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 执行用时： 24 ms , 在所有 Java 提交中击败了 12.61% 的用户
     * 内存消耗： 37.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int countLargestGroup(int n) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            int key = getBitSum(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        System.out.println("map = " + map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        int count = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1).getValue().equals(list.get(i).getValue())) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static int getBitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}
