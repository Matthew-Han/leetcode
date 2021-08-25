import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/24 09:17
 * @since 1.0
 **/
public class Ac3814 {

    /**
     * 矩阵变换
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        while (n-- > 0) {
            String str = sc.nextLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
            max = Math.max(max, map.get(str));
        }
        System.out.println(max);
    }
}
