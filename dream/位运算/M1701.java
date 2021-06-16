package 位运算;

/**
 * @ClassName AddWithoutPlus
 * @Description 面试题 17.01. 不用加号的加法
 * @Author MatthewHan
 * @Date 2020/7/29 10:19
 * @Version 1.0
 **/
public class M1701 {

    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(b ^ a, (a & b) << 1);
    }
}
