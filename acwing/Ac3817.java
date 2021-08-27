import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/27 11:14
 * @since 1.0
 **/
public class Ac3817 {

    /**
     * 数组
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        int min = arr2[n2 - b];
        for (int i = 0; i < a; i++) {
            if (arr1[i] >= min) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
