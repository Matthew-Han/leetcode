import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FizzBuzz
 * @Description #412 Fizz Buzz
 * @Author MatthewHan
 * @Date 2020/5/14 15:09
 * @Version 1.0
 **/
public class No412 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40.7 MB , 在所有 Java 提交中击败了 8.70% 的用户
     *
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i % 15 == 0 ? "FizzBuzz" : (i % 3 == 0 ? "Fizz" : (i % 5 == 0 ? "Buzz" : String.valueOf(i))));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }
}
