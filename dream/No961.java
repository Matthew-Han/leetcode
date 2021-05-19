import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NrepeatedElementInSize2NArray
 * @Description #961 重复 N 次的元素
 * @Author MatthewHan
 * @Date 2020/6/29 09:27
 * @Version 1.0
 **/
public class No961 {

    /**
     * @param arr
     * @return
     */
    public static int repeatedNTimesByOfficial(int[] arr) {
        if (arr[1] == arr[3]) {
            return arr[1];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return arr[0];
    }

    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 42.34% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param arr
     * @return
     */
    public static int repeatedNTimesPro(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        if (arr[len / 2 - 1] == arr[len / 2 - 2]) {
            return arr[len / 2 - 1];

        }
        if (arr[len / 2 + 1] == arr[len / 2]) {
            return arr[len / 2];
        }
        return arr[len / 2];
    }

    /**
     * 执行用时： 22 ms , 在所有 Java 提交中击败了 20.24% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 10.00% 的用户
     *
     * @param arr
     * @return
     */
    public static int repeatedNTimes(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == arr.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(repeatedNTimesByOfficial(new int[]{1, 2, 3, 2, 4, 2}));
    }
}
