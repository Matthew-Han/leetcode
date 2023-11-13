import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/25 10:26
 * @since 1.0
 **/
public class Ac3815 {

    /**
     * 最大约数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            long a = sc.nextLong();
            Set<Long> set = new TreeSet<>((o1, o2) -> Long.compare(o2, o1));
            for (long i = 1; i <= a / i; i++) {
                if (a % i == 0) {
                    set.add((long) i);
                    set.add((long) a / i);
                }
            }
            for (long fuck : set) {
                Set<Long> vis = new HashSet<>();
                for (long i = 1; i < fuck / i; i++) {
                    if (fuck % i == 0) {
                        vis.add((long) i);
                        vis.add((long) fuck / i);
                    }
                }
                vis.remove((long) 1);
                boolean flag = true;
                for (long v : vis) {
                    long d = (long) Math.sqrt(v);
                    if (Math.pow(d, 2) == v) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(fuck);
                    break;
                }
            }
        }
    }
}
