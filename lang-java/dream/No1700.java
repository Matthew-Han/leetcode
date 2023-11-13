import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/1/7 18:29
 **/
public class No1700 {

    /**
     * #1700 无法吃午餐的学生数量
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 8.03% 的用户
     * 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 18.03% 的用户
     *
     * @param students
     * @param sandwiches
     * @return
     */
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();

        for (int s : students) {
            queue.offer(s);
        }
        int stackIndex = 0;
        int c = 0;
        while (true) {
            if (queue.peek() == sandwiches[stackIndex]) {
                c = 0;
                queue.poll();
                stackIndex++;
            } else {
                int tmp = queue.poll();
                queue.offer(tmp);
            }
            if (c > queue.size()) {
                return queue.size();
            }
            if (queue.size() == 0) {
                return 0;
            }
            c++;
        }
    }
}