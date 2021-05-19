/**
 * @ClassName DistanceBetweenBusStops
 * @Description #1184 公交站间的距离
 * @Author MatthewHan
 * @Date 2020/7/7 16:12
 * @Version 1.0
 **/
public class No1184 {

    /**
     * 顺时针或者逆时针走，加起来的距离总和是数组元素之和，所以走一圈就vans了。
     * 算下其中一种走法距离为n，另一种走法距离就是total - n，取较小的距离就vans了。
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param distance
     * @param start
     * @param destination
     * @return
     */
    public static int distanceBetweenBusStopsPro(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int total = 0;
        for (int n : distance) {
            total += n;
        }
        int fuck = 0;
        for (int i = start; i < destination; i++) {
            fuck += distance[i];
        }
        return Math.min(fuck, total - fuck);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param distance
     * @param start
     * @param destination
     * @return
     */
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int min = Math.min(start, destination);
        int max = Math.max(destination, start);
        int minDistance1 = 0;
        int minDistance2 = 0;
        // 非套圈
        for (int i = min; i < max; i++) {
            minDistance1 += distance[i];
        }
        // 下面两个求套圈
        for (int i = 0; i < min; i++) {
            minDistance2 += distance[i];
        }
        for (int i = max; i < distance.length; i++) {
            minDistance2 += distance[i];
        }
        System.out.println("minDistance1 = " + minDistance1);
        System.out.println("minDistance2 = " + minDistance2);
        return Math.min(minDistance1, minDistance2);

    }

    public static void main(String[] args) {
        distanceBetweenBusStops(new int[]{3, 4, 2, 1, 2}, 0, 1);
    }
}
