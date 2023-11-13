import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/29 10:31
 * @since 1.0
 **/
public class Ac3783 {

    /**
     * 第 k 个除数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int k = sc.nextInt();
        List<Long> ans = new ArrayList<>();
        for (long i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                ans.add(i);
                if (n / i != i) {
                    ans.add(n / i);
                }
            }
        }
        Collections.sort(ans);
        if (k > ans.size()) {
            System.out.println(-1);
        } else {
            System.out.println(ans.get(k - 1));
        }

    }
}
