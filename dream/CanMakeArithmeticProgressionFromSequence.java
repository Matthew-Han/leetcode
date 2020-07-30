import java.util.Arrays;

/**
 * @ClassName CanMakeArithmeticProgressionFromSequence
 * @Description #1502 判断能否形成等差数列
 * @Author MatthewHan
 * @Date 2020/7/15 17:17
 * @Version 1.0
 **/
public class CanMakeArithmeticProgressionFromSequence {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.64% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @return
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[0] - arr[1];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] - arr[i + 1] != diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
