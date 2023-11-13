package 设计题;

import java.util.Stack;

/**
 * @ClassName design.MinStack
 * @Description #155 最小栈
 * @Author MatthewHan
 * @Date 2020/4/20 16:14
 * @Version 1.0
 **/
public class No155 {


    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 97.91% 的用户
     * 内存消耗 : 41.7 MB , 在所有 Java 提交中击败了 14.46% 的用户
     */
    public No155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.empty()) {
            minStack.push(x);
        } else if (x >= minStack.peek()) {
            minStack.push(x);
        } else {
            for (int i = 0; i <= minStack.size(); i++) {
                if (x < minStack.get(i)) {
                    minStack.insertElementAt(x, i);
                    break;
                }
            }
        }

    }

    public void pop() {
        minStack.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.firstElement();

    }

    @Override
    public String toString() {
        return "design.MinStack{" +
                "stack=" + stack +
                ", minStack=" + minStack +
                '}';
    }

    public static void main(String[] args) {

        No155 no155 = new No155();
        no155.push(-2);
        no155.push(0);
        no155.push(-3);
        no155.push(-11);
        no155.push(-1);
        System.out.println(no155.toString());
        System.out.println(no155.getMin());


        no155.pop();
        no155.top();

        System.out.println(no155.getMin());


    }


}

/*
 * Your design.MinStack object will be instantiated and called as such:
 * design.MinStack obj = new design.MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
