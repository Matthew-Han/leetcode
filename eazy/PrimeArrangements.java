/**
 * @ClassName PrimeArrangements
 * @Description #1175 质数排列
 * @Author MatthewHan
 * @Date 2020/7/7 15:08
 * @Version 1.0
 **/
public class PrimeArrangements {


    /**
     * 排序组合问题，求出n以内的x个质数，和n-x个非质数
     * x个质数按照Axx的形式全排列，n-x的非质数同理
     * 然后相乘，注意long和取模
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 62.66% 的用户
     * 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public static int numPrimeArrangements(int n) {
        int primeNumCount = fuck(n);
        int anotherCount = n - primeNumCount;
        long sum1 = 1;
        long sum2 = 1;
        for (int i = 2; i <= primeNumCount; i++) {
            sum1 *= i;
            sum1 %= 1000000007;
        }
        for (int i = anotherCount; i > 1; i--) {
            sum2 %= 1000000007;
            sum2 *= i;

        }
        return (int) (sum1 % 1000000007 * sum2 % 1000000007);
    }

    public static int fuck(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(100));
    }
}
