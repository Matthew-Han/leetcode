package 桶排序;

import java.util.*;

/**
 * @ClassName 桶排序.RelativeSortArray
 * @Description #1122 数组的相对排序
 * @Author MatthewHan
 * @Date 2020/7/6 15:40
 * @Version 1.0
 **/
public class RelativeSortArray {

    /**
     * 桶排序
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArrayBucketSort(int[] arr1, int[] arr2) {
        int[] bucket = new int[1000];
        for (int value : arr1) {
            bucket[value]++;
        }

        int i = 0;
        for (int value : arr2) {
            while (bucket[value] > 0) {
                arr1[i] = value;
                i++;
                bucket[value]--;
            }
        }

        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j] > 0) {
                arr1[i] = j;
                i++;
                bucket[j]--;
            }
        }
        return arr1;
    }

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 14.74% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArrayPro(int[] arr1, int[] arr2) {

        Arrays.sort(arr1);
        List<Integer> list = new ArrayList<>(arr1.length);
        for (int i : arr2) {
            list.add(i);
        }
        int curr = -1;
        int count = 0;
        for (int i : arr1) {
            if (i == curr) {
                count++;
            } else {
                count = 0;
            }
            curr = i;
            boolean isExisted = list.contains(i);
            // arr1存在
            if (count != 0 && isExisted) {
                list.add(list.indexOf(i), i);
                // arr1不存在
            } else if (count == 0 && !isExisted) {
                list.add(i);
            }

        }

        System.out.println("list = " + list);

        for (int i = 0; i < list.size(); i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }


    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 9.64% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>(arr1.length);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println("map = " + map);

        for (int value : arr2) {
            for (int k = 0; k < map.get(value); k++) {
                list.add(value);
            }
        }
        Arrays.sort(arr1);
        for (int value : arr1) {
            if (!list.contains(value)) {
                for (int k = 0; k < map.get(value); k++) {
                    list.add(value);
                }
            }
        }
        System.out.println("list = " + list);
        for (int i = 0; i < list.size(); i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArrayBucketSort(new int[]{28, 6, 22, 22, 8, 44, 5, 17}, new int[]{5, 22, 28, 8, 6})));
    }
}
