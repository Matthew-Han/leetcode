package design;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/25 15:03
 **/
public class DesignFrontMiddleBackQueue {

    List<Integer> data;
    int size;

    /**
     * #1670 设计前中后队列
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 49.57% 的用户
     * 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 39.25% 的用户
     */
    public DesignFrontMiddleBackQueue() {
        data = new LinkedList<>();
        size = 0;
    }

    public void pushFront(int val) {
        data.add(0, val);
        size++;
    }

    public void pushMiddle(int val) {
        data.add(size / 2, val);
        size++;
    }

    public void pushBack(int val) {
        data.add(val);
        size++;
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        size--;
        return data.remove(0);
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        size--;
        return data.remove(size / 2);
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        size--;
        return data.remove(size);
    }
}
