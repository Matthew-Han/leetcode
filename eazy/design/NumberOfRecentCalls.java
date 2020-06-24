package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName design.NumberOfRecentCalls
 * @Description #933 最近的请求次数
 * @Author MatthewHan
 * @Date 2020/6/24 15:30
 * @Version 1.0
 **/
public class NumberOfRecentCalls {

    Queue<Integer> queue;

    public NumberOfRecentCalls() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() + 3000 < t) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        NumberOfRecentCalls numberOfRecentCalls = new NumberOfRecentCalls();
        numberOfRecentCalls.ping(1);
        numberOfRecentCalls.ping(100);
        numberOfRecentCalls.ping(1000);
        numberOfRecentCalls.ping(3000);
        numberOfRecentCalls.ping(3001);
        System.out.println(numberOfRecentCalls.ping(3001));
        System.out.println(numberOfRecentCalls.ping(99000));

    }
}
