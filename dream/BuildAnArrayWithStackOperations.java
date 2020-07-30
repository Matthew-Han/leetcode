import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BuildAnArrayWithStackOperations
 * @Description #1441 用栈操作构建数组
 * @Author MatthewHan
 * @Date 2020/7/14 16:41
 * @Version 1.0
 **/
public class BuildAnArrayWithStackOperations {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param target
     * @param n
     * @return
     */
    public static List<String> buildArray(int[] target, int n) {

        int[] newTarget = new int[target.length + 1];
        System.arraycopy(target, 0, newTarget, 1, target.length);
        newTarget[0] = 0;
        int len = target[target.length - 1];

        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add("Push");
        }
        System.out.println("list = " + list);
        for (int i = newTarget.length - 1; i > 0; i--) {
            int diff = newTarget[i] - newTarget[i - 1];
            int index = newTarget[i];
            for (int j = 1; j < diff; j++) {
                list.add(--index, "Pop");
                System.out.println("index = " + index);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{2, 6}, 7));
    }
}
