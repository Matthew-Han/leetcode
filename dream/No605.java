import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CanPlaceFlowers
 * @Description #605 种花问题
 * @Author MatthewHan
 * @Date 2020/5/22 15:47
 * @Version 1.0
 **/
public class No605 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40.7 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        // 模拟最左边 + 0，所以是 1，后面中间段又会赋值 0 了
        int curr = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                curr++;
                // 模拟最右边位+0，所以不用减1
                if (i == flowerbed.length - 1) {
                    max += (curr) / 2;
                }
            } else {
                max += (curr - 1) / 2;
                curr = 0;
            }
        }
        return max >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0}, 21));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }
}
