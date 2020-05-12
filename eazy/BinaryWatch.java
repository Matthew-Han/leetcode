import java.util.List;

/**
 * @ClassName BinaryWatch
 * @Description #401 二进制手表
 * @Author MatthewHan
 * @Date 2020/5/12 16:54
 * @Version 1.0
 **/
public class BinaryWatch {


    public List<String> readBinaryWatch(int num) {
        if (num > 10) {
            return null;
        }
        int[] hour = {1, 2, 4, 8};
        int[] min = {1, 2, 4, 8, 16, 32};
        int hourMax = 12;
        int minMax = 60;

        return null;

    }


    public static void main(String[] args) {

    }
}
