import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 16:43
 * @description
 * @since 1.0.0
 **/
public class Ac3627 {

    /**
     * 最大差值
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int len = sc.nextInt();
            int k = sc.nextInt();
            PriorityQueue<Long> maxQ = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
            for (int i = 0; i < len; i++) {
                maxQ.offer((long) sc.nextInt());
            }
            while (k-- > 0) {
                Long max = maxQ.poll();
                Long secMax = maxQ.poll();
                maxQ.offer(max + secMax);
                maxQ.offer(0L);
            }
            System.out.println(maxQ.peek());

        }
    }
}
