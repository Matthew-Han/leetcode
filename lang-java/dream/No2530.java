import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @since 2023/10/18 16:09:50
 **/
public class No2530 {


    /**
     * 执行 K 次操作后的最大分数
     *
     * @param nums
     * @param k
     * @return
     */
    public long maxKelements(int[] nums, int k) {
        long res = 0L;
        PriorityQueue<Integer> queue = Arrays.stream(nums).boxed().collect(() -> new PriorityQueue<>((o1, o2) -> o2 - o1), PriorityQueue::add, PriorityQueue::addAll);
        while (k-- > 0) {
            Integer val = queue.poll();
            res += val;
            val = (val + 3 - 1) / 3;
            queue.offer(val);
        }
        return res;
    }
}
