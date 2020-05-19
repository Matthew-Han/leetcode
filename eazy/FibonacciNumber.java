/**
 * @ClassName FibonacciNumber
 * @Description #509 斐波那契数
 * @Author MatthewHan
 * @Date 2020/5/19 14:52
 * @Version 1.0
 **/
public class FibonacciNumber {

    public static int fib(int N) {
        int first = 1;
        int second = 1;
        int last = first + second;
        int next = last;
        while (N > 3) {
            last = next;
            next = last + next;


            N--;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
