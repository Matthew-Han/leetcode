import java.util.Stack;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/8/31 10:59 31
 * @since 1.0
 **/
public class No946 {

    /**
     * 验证栈序列
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int pop : popped) {
            fuck:
            if (!stack.isEmpty() && stack.peek() == pop) {
                stack.pop();
            } else {
                for (int i = idx; i < pushed.length; i++) {
                    if (pushed[i] != pop) {
                        stack.push(pushed[i]);
                    } else {
                        idx = i + 1;
                        break fuck;
                    }
                }
                return false;
            }
        }
        return true;

    }
}
