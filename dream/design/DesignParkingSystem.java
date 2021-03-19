package design;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/19 09:47
 **/
public class DesignParkingSystem {

    int[] p;

    /**
     * #1603 设计停车系统
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 96.81% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 15.22% 的用户
     *
     * @param big
     * @param medium
     * @param small
     */
    public DesignParkingSystem(int big, int medium, int small) {
        p = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        if (p[carType] > 0) {
            p[carType] -= 1;
            return true;
        }
        return false;
    }
}
