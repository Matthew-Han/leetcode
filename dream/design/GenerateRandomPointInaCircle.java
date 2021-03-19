package design;

import java.util.Random;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/19 09:55
 **/
public class GenerateRandomPointInaCircle {

    double offsetX, offsetY;
    double radius, xCenter, yCenter;

    /**
     * #478 在圆内随机生成点
     * 执行用时： 262 ms , 在所有 Java 提交中击败了 43.79% 的用户
     * 内存消耗： 47.6 MB , 在所有 Java 提交中击败了 94.67% 的用户
     *
     * @param radius
     * @param xCenter
     * @param yCenter
     */
    public GenerateRandomPointInaCircle(double radius, double xCenter, double yCenter) {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        offsetX = xCenter - radius;
        offsetY = yCenter - radius;
    }

    public double[] randPoint() {
        double x, y, rr = -1;
        do {
            x = new Random().nextDouble() * radius * 2 + offsetX;
            y = new Random().nextDouble() * radius * 2 + offsetY;
            rr = Math.pow((x - xCenter), 2) + Math.pow((y - yCenter), 2);
        } while (rr < Math.pow(radius, 2));
        return new double[]{x, y};

    }
}
