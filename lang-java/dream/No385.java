import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/22 15:46 22
 * @since 1.0
 **/
public class No385 {


    /**
     * 迷你语法分析器
     *
     * @param s
     * @return
     */
    public NestedInteger deserialize(String s) {
        NestedInteger head = new NestedInteger();
        Stack<NestedInteger> stack = new Stack<>();
        String[] arr = s.split(",");
        for (String value : arr) {
            char[] sub = value.toCharArray();
            Integer number = fuck(sub);
            NestedInteger prev;
            if (stack.isEmpty()) {
                prev = head;
            } else {
                prev = stack.peek();
            }
            for (char c : sub) {
                if (c == '[') {
                    NestedInteger list = new NestedInteger();
                    prev.add(list);
                    stack.add(list);
                    prev = list;
                } else {
                    break;
                }
            }
            if (number != null) {
                NestedInteger curr = new NestedInteger(number);
                prev.add(curr);
            }
            for (int j = sub.length - 1; j >= 0; j--) {
                if (sub[j] == ']') {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        return head.getList().getFirst();
    }

    public Integer fuck(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '[' && c != ']') {
                sb.append(c);
            }
        }
        return sb.isEmpty() ? null : Integer.parseInt(sb.toString());
    }


    public static class NestedInteger {
        Integer val;

        List<NestedInteger> nxt;


        public NestedInteger() {
            this.nxt = new ArrayList<>();
        }

        public NestedInteger(int val) {
            this.val = val;
            this.nxt = new ArrayList<>();
        }

        public boolean isInteger() {
            return val == null;
        }

        public Integer getInteger() {
            return val;
        }

        void setInteger(int value) {
            this.val = value;
        }

        void add(NestedInteger ni) {
            this.nxt.add(ni);
        }

        List<NestedInteger> getList() {
            return nxt;
        }

        @Override
        public String toString() {
            return "ni{" +
                    "val=" + val +
                    ", nxt=" + nxt +
                    '}';
        }
    }
}
