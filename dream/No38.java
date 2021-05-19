import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName CountAndSay
 * @Description #38 外观数列
 * @Author MatthewHan
 * @Date 2020/4/13 09:59
 * @Version 1.0
 **/
public class No38 {


    /**
     * 2021.5.19 更新解法
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 6.     312211
     * 7.     13112221
     * 8.     1113213211
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String ans = "1";
        String prev = "1";
        Queue<Character> queue;
        while (n > 1) {
            queue = new LinkedList<>();
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < prev.length(); i++) {
                if (queue.isEmpty() || queue.peek() == prev.charAt(i)) {
                    queue.offer(prev.charAt(i));
                }
                if (queue.peek() != prev.charAt(i)) {
                    tmp.append(queue.size()).append(queue.peek());
                    queue.clear();
                    queue.offer(prev.charAt(i));
                }
                if (i == prev.length() - 1) {
                    tmp.append(queue.size()).append(queue.peek());
                }
            }
            prev = tmp.toString();
            ans = prev;
            n--;
        }
        return ans;
    }


}
