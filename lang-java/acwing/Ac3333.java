import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a >
 * @date 2021/6/19 9:17 下午
 * @since 1.0
 **/
public class Ac3333 {

    /**
     * K-优字符串
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int j = 0; j < n; j++) {
            int size = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            char[] arr = sc.nextLine().toCharArray();

            int currSorce = 0;
            for (int i = 0; i < size / 2; i++) {
                currSorce += arr[i] != arr[arr.length - 1 - i] ? 1 : 0;
            }
            System.out.printf("Case #%d: %d\n", j + 1, Math.abs(currSorce - k));
        }
    }
}
