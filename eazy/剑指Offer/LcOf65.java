package 剑指Offer;

/**
 * @ClassName LcOf65
 * @Description 剑指 Offer #65 不用加减乘除做加法
 * @Author MatthewHan
 * @Date 2020/7/23 09:02
 * @Version 1.0
 **/
public class LcOf65 {

    public static int add(int a, int b) {
        // 当进位为 0 时跳出
        while (b != 0) {
            // c = 进位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
