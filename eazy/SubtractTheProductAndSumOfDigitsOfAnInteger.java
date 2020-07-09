/**
 * @ClassName SubtractTheProductAndSumOfDigitsOfAnInteger
 * @Description #1281 整数的各位积和之差
 * @Author MatthewHan
 * @Date 2020/7/9 10:02
 * @Version 1.0
 **/
public class SubtractTheProductAndSumOfDigitsOfAnInteger {


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.6 MB , 在所有 Java 提交中击败了 6.06% 的用户
     *
     * @param n
     * @return
     */
    public static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        while (n > 0) {
            int temp1 = n % 10;
            product *= temp1;
            sum += temp1;
            n /= 10;
        }
        return product - sum;
    }


    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(188));
    }
}
