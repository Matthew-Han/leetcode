package 第51场双周赛;

/**
 * @author Matthew Han
 * @description
 * @date 2021/5/2 20:45
 * @since 1.0.0
 **/
public class No1845 {

    boolean[] data;
    int index;

    /**
     * #1845 座位预约管理系统
     *
     * @param n
     */
    public No1845(int n) {
        index = 0;
        data = new boolean[n + 1];
    }

    public int reserve() {
        data[index] = true;
        int ans = index;
        for (int i = index + 1; i < data.length; i++) {
            if (!data[i]) {
                index = i;
                break;
            }
        }
        return ans + 1;
    }

    public void unreserve(int seatNumber) {
        data[seatNumber - 1] = false;
        if (index > seatNumber - 1) {
            index = seatNumber - 1;
        }
    }
}
