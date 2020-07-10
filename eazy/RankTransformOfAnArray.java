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
     * 利用二维数组，之前用二维数组没做出来，晚上突然懂了，就把这题的二维数组解法写出来
     * 不过超时了。。
     *
     * @param arr
     * @return
     */
    public static int[] arrayRankTransformPro(int[] arr) {
        if (arr.length == 0) {
            return new int[]{};
        }
        int[] result = new int[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);
        Arrays.sort(arr);
        int[][] temp = new int[arr.length][2];
        int index = 1;
        temp[0][0] = arr[0];
        temp[0][1] = 1;
        for (int i = 1; i < arr.length; i++) {
            temp[i][0] = arr[i];
            if (arr[i - 1] != arr[i]) {
                index++;
            }
            temp[i][1] = index;
        }
        System.out.println("temp = " + Arrays.deepToString(temp));
        for (int i = 0; i < result.length; i++) {
            for (int[] ints : temp) {
                if (result[i] == ints[0]) {
                    result[i] = ints[1];
                    break;
                }
            }
        }
        return result;

    }

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
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{})));
    }
}



