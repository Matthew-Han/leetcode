package 第198场周赛;

/**
 * @ClassName WaterBottles
 * @Description #5464 换酒问题
 * @Author MatthewHan
 * @Date 2020/7/19 10:24
 * @Version 1.0
 **/
public class WaterBottles {

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
