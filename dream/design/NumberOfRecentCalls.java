package design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    List<Integer> list;
    LinkedList<Integer> linkedList;

    /**
     * Queue:
     * 执行用时： 28 ms , 在所有 Java 提交中击败了 89.56% 的用户
     * 内存消耗： 48.3 MB , 在所有 Java 提交中击败了 100.00% 的用户
     * <p>
     * List:
     * 执行用时： 471 ms , 在所有 Java 提交中击败了 6.50% 的用户
     * 内存消耗： 49.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     * 这个顺序表就是逊啦
     * <p>
     * LinkedList插入和删除的优势就体现出来了
     */
    public NumberOfRecentCalls() {
        queue = new LinkedList<>();
        list = new ArrayList<>();
        linkedList = new LinkedList<>();
    }

    public int ping(int t) {
        /*
         *
         * queue实现
         */
        queue.offer(t);
        while (t - 3000 > queue.peek()) {
            queue.poll();
        }
        /*
         * list实现
         */
        list.add(t);
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (t - 3000 > list.get(i)) {
                return count;
            } else {
                count++;
            }
        }

        /*
         * linkedList实现
         */
        linkedList.add(t);
        while (t - 3000 > linkedList.getFirst()) {
            linkedList.removeFirst();
        }
        return linkedList.size();
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

class Clazz {
    LinkedList<Integer> linkedList;

    public Clazz() {
        linkedList = new LinkedList<>();

    }

    public int ping(int t) {

        linkedList.add(t);
        while (t - 3000 > linkedList.getFirst()) {
            linkedList.removeFirst();
        }
        return linkedList.size();
    }

    public static void main(String[] args) {
        Clazz numberOfRecentCalls = new Clazz();
        numberOfRecentCalls.ping(1);
        numberOfRecentCalls.ping(100);
        numberOfRecentCalls.ping(3001);
        System.out.println(numberOfRecentCalls.ping(3002));

    }
}