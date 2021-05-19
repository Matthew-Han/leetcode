import javafx.util.Pair;
import java.util.Arrays;


/**
 * @ClassName NextGreaterElementIII
 * @Description #556 下一个更大元素 III
 * @Author MatthewHan
 * @Date 2020/8/28 13:37
 * @Version 1.0
 **/
public class No556 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 53.21% 的用户
     * 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 74.42% 的用户
     *
     * @param n
     * @return
     */
    public static int nextGreaterElement(int n) {
        // 是否是全倒序
        if (check(n)) {
            return -1;
        }
        int len = 0;
        int tmp = n;
        while (tmp > 0) {
            len++;
            tmp /= 10;
        }
        int[] arr = new int[len];
        tmp = len;
        while (n > 0) {
            arr[--tmp] = n % 10;
            n /= 10;
        }
        // 记录每个需要交换的位置 from 和 to，留下下标较大的那个（使得该数最小）
        Pair<Integer, Integer> pair = new Pair<>(-1, -1);
        for (int right = len - 1; right > 0; right--) {
            for (int left = right - 1; left >= 0; left--) {
                if (arr[right] > arr[left]) {
                    if (left > pair.getKey()) {
                        pair = new Pair<>(left, right);
                    }
                    break;
                }
            }
        }

        int from = pair.getKey();
        int to = pair.getValue();
        // 对有效的两个位置下标进行交换
        arr[from] = arr[from] ^ arr[to];
        arr[to] = arr[from] ^ arr[to];
        arr[from] = arr[from] ^ arr[to];
        // from后面到尾部进行排序
        Arrays.sort(arr, from + 1, len);
        return packageNumber(arr);

    }

    public static boolean check(int n) {
        int tmp = n;
        // 每一位是个位数
        int prev = -1;
        boolean flag = true;
        while (tmp > 0) {
            int next = tmp % 10;
            if (next < prev) {
                flag = false;
            }
            prev = next;
            tmp /= 10;
        }

        return flag;
    }

    /**
     * 防止溢出，例：1999999999。用long类型。若溢出了return -1
     *
     * @param arr
     * @return
     */
    public static int packageNumber(int[] arr) {
        long carry = 1;
        long ans = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            ans += carry * arr[i];
            carry *= 10;
        }
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(1999999999));
        System.out.println(nextGreaterElement(230241));
        System.out.println(nextGreaterElement(32112));
        System.out.println(nextGreaterElement(12576));
        System.out.println(nextGreaterElement(12886));
        System.out.println(nextGreaterElement(123871731));

    }


}
