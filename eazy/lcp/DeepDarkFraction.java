package lcp;

/**
 * @ClassName DeepDarkFraction
 * @Description #LCP 02 分式化简
 * @Author MatthewHan
 * @Date 2020/7/15 17:54
 * @Version 1.0
 **/
public class DeepDarkFraction {

    public static int[] fraction(int[] cont) {
        double avg = (double) 1 / cont[cont.length - 1];
        for (int i = cont.length - 2; i > 0; i--) {
            avg = 1 / (cont[i] + avg);
        }
        avg += cont[0];
        System.out.println("avg = " + avg);
        // 整数
        if (avg % 1 == 0) {
            return new int[]{(int) avg, 1};
        } else {
            int n = 2;

        }
        return null;
    }

    public static void main(String[] args) {
        fraction(new int[]{3, 2, 0, 2});
    }
}
