package 设计题;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/10/9 09:01
 * @since 1.0
 **/
public class No284 implements Iterator<Integer> {


    Queue<Integer> data;

    /**
     * 顶端迭代器
     *
     * @param iterator
     */
    public No284(Iterator<Integer> iterator) {
        data = new LinkedList<>();
        while (iterator.hasNext()) {
            data.offer(iterator.next());
        }
    }

    public Integer peek() {
        return data.peek();
    }


    @Override
    public boolean hasNext() {
        return !data.isEmpty();
    }

    @Override
    public Integer next() {
        return data.poll();
    }

}
