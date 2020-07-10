/**
 * @ClassName ConvertIntegerToTheSumOfTwoNoZeroIntegers
 * @Description #1317 将整数转换为两个无零整数的和
 * @Author MatthewHan
 * @Date 2020/7/10 12:34
 * @Version 1.0
 **/
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 84.45% 的用户
     * 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int[] getNoZeroIntegers(int n) {
        int i = 1;
        int j = n - i;
        while (true) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(j).contains("0")) {
                return new int[]{i, j};
            }
            i += 1;
            j = n - i;
        }
    }

    public static boolean hasZero(int[] arr) {
        for (int n : arr) {
            while (n > 0) {
                if (n % 10 == 0) {
                    return true;
                }
                n /= 10;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        for (int i = 11; i <= 10000; i++) {
            if (hasZero(getNoZeroIntegers(i))) {
                System.out.println("妈妈，有鸡");
                break;
            }
        }

    }
}
