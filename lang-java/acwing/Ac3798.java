import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/10 09:21
 * @since 1.0
 **/
public class Ac3798 {

    public static TreeSet<Long> set;

    public static void init() {
        set = new TreeSet<>();
        long s = 1L;
        while (s <= 1e10) {
            for (int i = 1; i < 10; i++) {
                set.add(i * s);
            }
            s *= 10;
        }
    }

    /**
     * 幸运年份
     *
     * @param args
     */
    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            System.out.println(set.higher((long) a) - a);

        }
    }
}
