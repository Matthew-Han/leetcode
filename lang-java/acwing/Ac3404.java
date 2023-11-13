import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/25 17:10
 * @since 1.0
 **/
public class Ac3404 {


    /**
     * 谁是你的潜在朋友
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] likes = new int[m + 1];
        int[] reader = new int[n];
        for (int i = 0; i < n; i++) {
            reader[i] = sc.nextInt();
            likes[reader[i]]++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(likes[reader[i]] > 1 ? likes[reader[i]] - 1 : "BeiJu");
        }
    }

}
