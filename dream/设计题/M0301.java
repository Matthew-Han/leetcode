package 设计题;

import java.util.Arrays;

/**
 * @ClassName ThreeInOne
 * @Description 面试题 03.01. 三合一
 * @Author MatthewHan
 * @Date 2020/7/24 09:12
 * @Version 1.0
 **/
public class M0301 {

    private final int[] data;
    private final int size;
    private final int capacity;


    /**
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 56.62% 的用户
     * 内存消耗： 49.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param stackSize
     */
    public M0301(int stackSize) {
        capacity = stackSize * 3;
        size = capacity + 3;
        data = new int[size];
    }

    public void push(int stackNum, int value) {
        int index = headIndex(stackNum);
        System.out.println("index = " + index);

        // 头指针，还有容量计数功能，如果超过容量，就塞不了
        if (data[index] < capacity / 3) {
            data[index]++;
            // 剩余位置塞
            data[index + data[index]] = value;
        }
    }

    public int pop(int stackNum) {
        int index = headIndex(stackNum);
        // stack 为空
        if (data[index] == 0) {
            return -1;
        } else {
            int temp = data[index + data[index]];
            data[index]--;
            // 这里并不需要真的删除这个元素
            return temp;
        }
    }

    public int peek(int stackNum) {
        int index = headIndex(stackNum);
        if (data[index] == 0) {
            return -1;
        } else {
            return data[index + data[index]];
        }
    }

    public boolean isEmpty(int stackNum) {
        return data[headIndex(stackNum)] == 0;
    }

    /**
     * 根据 stack 下标取头指针
     * @param stackNum
     * @return
     */
    public int headIndex(int stackNum) {
        int index = 0;
        switch (stackNum) {
            case 1:
                index = capacity / 3 + 1;
                break;
            case 2:
                index = size - 1 - capacity / 3;
                break;
            default:
        }
        return index;
    }

    @Override
    public String toString() {
        return "ThreeInOne{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        M0301 m0301 = new M0301(1);
        m0301.push(0, 22);
        m0301.push(1, 33);
        System.out.println(m0301.isEmpty(1));
        System.out.println("threeInOne = " + m0301);
    }
}
