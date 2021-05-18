import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinaryPrefixDivisibleBy5
 * @Description #1018 可被 5 整除的二进制前缀
 * @Author MatthewHan
 * @Date 2020/7/1 16:45
 * @Version 1.0
 **/
public class No1018 {

    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 70.36% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 50.00% 的用户
     *
     * @param arr
     * @return
     */
    public static List<Boolean> prefixesDivBy5(int[] arr) {

        List<Boolean> list = new ArrayList<>(arr.length);
        int num = 0;
        for (int value : arr) {
            num <<= 1;
            num += value;
            num %= 10;
            list.add(num % 5 == 0);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}));
    }
}
