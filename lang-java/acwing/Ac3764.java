import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a >
 * @date 2021/7/13 7:30 下午
 * @since 1.0
 **/
public class Ac3764 {


    /**
     * 三元数异或
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int k = sc.nextInt();
            sc.nextLine();
            char[] arr = sc.nextLine().toCharArray();
            StringBuilder a = new StringBuilder("1");
            StringBuilder b = new StringBuilder("1");
            boolean flag = true;
            for (int i = 1; i < arr.length; i++) {
                if (flag) {
                    if (arr[i] == '0') {
                        a.append(0);
                        b.append(0);
                    } else if (arr[i] == '1') {
                        a.append(1);
                        b.append(0);
                        flag = false;
                    } else {
                        a.append(1);
                        b.append(1);
                    }
                } else {
                    if (arr[i] == '0') {
                        a.append(0);
                        b.append(0);
                    } else if (arr[i] == '1') {
                        a.append(0);
                        b.append(1);
                    } else {
                        a.append(0);
                        b.append(2);
                    }
                }

            }
            System.out.println(a);
            System.out.println(b);
        }
    }



}
