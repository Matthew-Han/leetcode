import java.util.*;

/**
 * @ClassName RankTransformOfAnArray
 * @Description #1331 数组序号转换
 * @Author MatthewHan
 * @Date 2020/7/10 14:39
 * @Version 1.0
 **/
public class RankTransformOfAnArray {

    /**
     * 执行用时： 53 ms , 在所有 Java 提交中击败了 15.02% 的用户
     * 内存消耗： 62.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @return
     */
    public static int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new TreeSet<>(Integer::compareTo);
        for (int n : arr) {
            set.add(n);
        }
        Map<Integer, Integer> map = new HashMap<>(set.size() * 4 / 3 + 1);
        int index = 0;
        for (Integer n : set) {
            map.put(n, ++index);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{10, 20, 20, 5})));
    }
}



