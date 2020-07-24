package 面试题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName AnimalShelter
 * @Description 面试题 03.06. 动物收容所
 * @Author MatthewHan
 * @Date 2020/7/25 02:46
 * @Version 1.0
 **/
public class AnimalShelter {

    private final Queue<Integer> catQueue;
    private final Queue<Integer> dogQueue;
    private final Queue<int[]> allQueue;
    private int capacity;
    private final int MAX_CAPACITY = 20000;

    /**
     * 三个队列实现同步（cat与any、dog与any同步）
     * 执行用时： 99 ms , 在所有 Java 提交中击败了 66.30% 的用户
     * 内存消耗： 49.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     */
    public AnimalShelter() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
        allQueue = new LinkedList<>();
        capacity = 0;
    }

    public void enqueue(int[] animal) {
        if (capacity < MAX_CAPACITY) {
            if (animal[1] == 0) {
                catQueue.offer(animal[0]);
            } else {
                dogQueue.offer(animal[0]);
            }
            allQueue.offer(animal);
            capacity++;
        }
    }

    public int[] dequeueAny() {
        if (allQueue.size() > 0) {
            int[] temp = allQueue.poll();
            if (temp[1] == 0) {
                catQueue.poll();
            } else {
                dogQueue.poll();
            }
            capacity--;
            return temp;
        } else {
            return new int[]{-1, -1};
        }
    }

    public int[] dequeueDog() {
        if (dogQueue.size() > 0) {
            capacity--;
            // 同步allQueue
            for (int[] ints : allQueue) {
                if (ints[1] == 1) {
                    allQueue.remove(ints);
                    break;
                }
            }

            return new int[]{dogQueue.poll(), 1};
        } else {
            return new int[]{-1, -1};
        }
    }

    public int[] dequeueCat() {
        if (catQueue.size() > 0) {
            capacity--;
            // 同步allQueue
            for (int[] ints : allQueue) {
                if (ints[1] == 0) {
                    allQueue.remove(ints);
                    break;
                }
            }
            return new int[]{catQueue.poll(), 0};
        } else {
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
    }
}
