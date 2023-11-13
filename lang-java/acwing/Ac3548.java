import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:46
 * @description
 * @since 1.0.0
 **/
public class Ac3548 {

    /**
     * 双端队列
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> leftMap = new HashMap<>();
        Map<String, Integer> rightMap = new HashMap<>();
        int lMin = 0;
        int rMin = 0;
        for (int i = 0; i < n; i++) {
            String[] curr = sc.nextLine().split(" ");
            if ("L".equals(curr[0])) {
                leftMap.put(curr[1], lMin);
                rightMap.put(curr[1], -lMin);

                if (lMin == 0) {
                    rMin = -1;
                }
                lMin--;

            } else if ("R".equals(curr[0])) {
                rightMap.put(curr[1], rMin);
                leftMap.put(curr[1], -rMin);
                if (rMin == 0) {
                    lMin = -1;
                }
                rMin--;
            } else {
                System.out.println(Math.min(leftMap.get(curr[1]) - lMin - 1, rightMap.get(curr[1]) - rMin - 1));
            }

        }
    }

}
