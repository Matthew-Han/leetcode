package 第198场周赛;

/**
 * @ClassName WaterBottles
 * @Description #1518 换酒问题
 * @Author MatthewHan
 * @Date 2020/7/19 10:24
 * @Version 1.0
 **/
public class WaterBottles {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 31.48% 的用户
     *
     * @param numBottles
     * @param numExchange
     * @return
     */
    public static int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        int c = numBottles;
        while (c >= numExchange) {
            int temp = numBottles / numExchange;
            count += temp;
            c -= numBottles;
            c += (temp + numBottles % numExchange);
            numBottles = c;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(numWaterBottles(2, 3));

    }
}
