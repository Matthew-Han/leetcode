import com.sun.prism.impl.shape.BasicRoundRectRep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MinimumAbsoluteDifference
 * @Description #1200 最小绝对差
 * @Author MatthewHan
 * @Date 2020/7/7 17:51
 * @Version 1.0
 **/
public class MinimumAbsoluteDifference {

    /**
     * 执行用时： 18 ms , 在所有 Java 提交中击败了 96.30% 的用户
     * 内存消耗： 50.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @return
     */
    public static List<List<Integer>> minimumAbsDifferencePro(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (min == arr[i + 1] - arr[i]) {
                // 这里初始化容量为 2 ，性能提高 88.8888 %
                List<Integer> temp = new ArrayList<>(2);
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                list.add(temp);
            }
        }
        return list;
    }

    /**
     * 执行用时： 18 ms , 在所有 Java 提交中击败了 96.30% 的用户
     * 内存消耗： 50.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @return
     */
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                // clear()方法比新建对象快
                list.clear();
                min = diff;
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                list.add(temp);
            } else if (diff == min) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                list.add(temp);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifferencePro(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }
}
