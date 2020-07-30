import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UglyNumber
 * @Description #263 丑数
 * @Author MatthewHan
 * @Date 2020/5/6 16:11
 * @Version 1.0
 **/
public class UglyNumber {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.1 MB , 在所有 Java 提交中击败了 5.55% 的用户
     *
     * @param num
     * @return
     */
    public static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        /*
         * 如果只有2、3、5质因数的话，最后都会变成1，若=1则是丑数
         * 假如14这种，第一个因数是2，第二个为7，无法对2、3、5取模为0不仅如此if语句，也不会等于1
         */
        while (true) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return num == 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isUgly(8));
    }
}
