package 面试题;

/**
 * @ClassName FactorialZeros
 * @Description 面试题 16.05. 阶乘尾数
 * @Author MatthewHan
 * @Date 2020/7/29 09:10
 * @Version 1.0
 **/
public class FactorialZeros {

    public int trailingZeroes(int n) {

        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;

    }
}
