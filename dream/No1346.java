import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CheckIfnAndItsDoubleExist
 * @Description #1346 检查整数及其两倍数是否存在
 * @Author MatthewHan
 * @Date 2020/7/10 23:36
 * @Version 1.0
 **/
public class No1346 {

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 21.39% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @return
     */
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>(arr.length);
        int count0 = 0;
        for (int n : arr) {
            if (n != 0) {
                set.add(n);
            } else {
                count0++;
            }
        }
        if (count0 >= 2) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }

        for (int n : arr) {
            if (set.contains(n)) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {

    }

}
