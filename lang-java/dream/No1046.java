import java.util.PriorityQueue;

/**
 * @ClassName LastStoneWeight
 * @Description #1046 最后一块石头的重量
 * @Author MatthewHan
 * @Date 2020/7/4 23:15
 * @Version 1.0
 **/
public class No1046 {

    /**
     * 大顶堆
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 81.02% 的用户
     * 内存消耗： 37.4 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length, (o1, o2) -> o2 - o1);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            System.out.println(maxHeap);
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (first > second) {
                maxHeap.offer(first - second);
            }

        }
        return maxHeap.size() == 0 ? 0 : maxHeap.poll();

    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{9, 8, 7, 6, 23, 43, 54, 75, 32, 2, 1, 8, 77}));
    }
}
