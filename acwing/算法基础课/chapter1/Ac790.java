package 算法基础课.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/7/4 10:37 04
 * @since 1.0
 **/
public class Ac790 {

    /**
     * 数的三次方根
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(sc.readLine());
        double l = -10000.00;
        double r = 10000.00;
        while (r - l > 1e-8) {
            double mid = (r + l) / 2;
            if (mid * mid * mid <= n) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.printf("%.6f%n", r);
    }
}
