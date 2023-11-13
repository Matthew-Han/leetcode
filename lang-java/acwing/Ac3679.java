import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 15:34
 * @description
 * @since 1.0.0
 **/
public class Ac3679 {


    /**
     * 素数矩阵
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int curr = sc.nextInt();
            int[] arr = build(curr);
            int tmp = curr;
            int start = 0;
            while (tmp-- > 0) {
                int limit = 0;
                for (int i = start; i < curr; i++, i %= curr) {
                    if (limit == curr) {
                        break;
                    }
                    System.out.print(arr[i]);
                    System.out.print(" ");
                    limit++;
                }
                System.out.println();
                start++;
            }
        }
    }

    public static int[] build(int n) {
        int[] arr = new int[n];
        int sum = 0;
        int val = 2;
        int index = 0;
        while (true) {
            if (index == n - 1 && !isPrime(val) && isPrime(sum + val)) {
                arr[index] = val;
                break;
            }
            if (index < n - 1 && !isPrime(val)) {
                arr[index++] = val;
                sum += val;
            }
            val++;

        }
        return arr;
    }

    public static boolean isPrime(int n) {
        for (int j = 2; j < n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

}
