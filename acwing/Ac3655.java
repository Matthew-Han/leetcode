import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:54
 * @description
 * @since 1.0.0
 **/
public class Ac3655 {

    /**
     * 楼层
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int index = 1;
            int min = 0;
            int max = 2;
            while (true) {
                if (a >= min && a <= max) {
                    System.out.println(index);
                    break;
                }
                index++;
                min = max + 1;
                max = (index - 1) * b + 2;
            }
        }
    }
}
