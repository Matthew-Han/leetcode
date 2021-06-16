import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:40
 * @description
 * @since 1.0.0
 **/
public class Ac3577 {

    /**
     * 选择数字
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        boolean[] bucket = new boolean[401];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
            bucket[arr1[i]] = true;
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
            bucket[arr2[i]] = true;
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (!bucket[arr1[i] + arr2[j]]) {
                    System.out.println(arr1[i] + " " + arr2[j]);
                    return;
                }
            }
        }

    }
}
