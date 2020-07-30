import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName PowerfulIntegers
 * @Description #970 强整数
 * @Author MatthewHan
 * @Date 2020/6/29 10:31
 * @Version 1.0
 **/
public class PowerfulIntegers {


    /**
     * 逆向思维
     * 算i和j小于18的所有可能就行了，只要比bound小
     *
     * @param x
     * @param y
     * @param bound
     * @return
     */
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 20 && Math.pow(x, i) <= bound; ++i) {
            for (int j = 0; j < 20 && Math.pow(y, j) <= bound; ++j) {
                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (v <= bound) {
                    seen.add(v);
                }
            }
        }
        return new ArrayList<>(seen);

    }


    public static void main(String[] args) {
        System.out.println(powerfulIntegers(3, 2, 2000));
    }


}
