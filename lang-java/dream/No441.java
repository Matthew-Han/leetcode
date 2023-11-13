/**
 * @ClassName ArrangingCoins
 * @Description #441 排列硬币
 * @Author MatthewHan
 * @Date 2020/5/15 09:22
 * @Version 1.0
 **/
public class No441 {

    /**
     * 执行用时 : 12 ms , 在所有 Java 提交中击败了 17.22% 的用户
     * 内存消耗 : 37 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
        int layer = 1;
        int number = 0;
        int temp = n;
        while (number < n) {
            number = number + layer;
            temp -= layer;
            layer++;
            if (temp < 0) {
                return layer - 2;
            } else if (temp == 0) {
                return layer - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(3));
    }
}
