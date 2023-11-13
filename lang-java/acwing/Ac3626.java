import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:44
 * @description
 * @since 1.0.0
 **/
public class Ac3626 {

    /**
     * 三元一次方程
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            boolean flag = false;
            int curr = sc.nextInt();
            fuck:
            for (int x = 0; x <= curr; x++) {
                for (int y = 0; y <= curr; y++) {
                    for (int z = 0; z <= curr; z++) {
                        if (3 * x + 5 * y + 7 * z == curr) {
                            System.out.println(x + " " + y + " " + z);
                            flag = true;
                            break fuck;
                        }
                    }
                }
            }
            if (!flag) {
                System.out.println(-1);
            }
        }
    }
}
