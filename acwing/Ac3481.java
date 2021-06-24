import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/24 14:49
 * @since 1.0
 **/
public class Ac3481 {

    static boolean flag = false;

    /**
     * 阶乘的和
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int a = 1;
        list.add(a);
        int index = 2;
        while (a <= 1000001) {
            list.add(a);
            a *= index++;
        }
        while (sc.hasNext()) {
            flag = false;
            int target = sc.nextInt();
            if (target < 0) {
                break;
            }
            dfs(list, 0, 0, target);
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void dfs(List<Integer> list, int index, int sum, int target) {
        if (flag) {
            return;
        }
        if (sum == target && sum != 0) {
            flag = true;
            return;
        }
        for (int i = index; i < list.size(); i++) {
            dfs(list, i + 1, sum + list.get(i), target);

            dfs(list, i + 1, sum, target);
        }
    }
}
