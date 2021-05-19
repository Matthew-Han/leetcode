import java.util.Arrays;

/**
 * @ClassName SortIntegersByTheNumberOf1Bits
 * @Description #1356 根据数字二进制下 1 的数目排序
 * @Author MatthewHan
 * @Date 2020/7/11 01:45
 * @Version 1.0
 **/
public class No1356 {

    /**
     * 字符串判断1的位数，不行，Integer.bitCount()方法，行！
     * <p>
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 67.49% 的用户
     * 内存消耗： 40.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     */
    public static int[] sortByBits(int[] arr) {
        Integer[] result = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        Arrays.sort(result, (o1, o2) -> {
            int c1 = Integer.bitCount(o1);
            int c2 = Integer.bitCount(o2);
            if (c1 < c2) {
                return -1;
            } else if (c1 == c2) {
                return o1 < o2 ? -1 : 1;
            } else {
                return 1;
            }
        });
        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(new int[]{88, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
    }

}
