package 双指针;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName 双指针.SortArrayByParity
 * @Description #905 按奇偶排序数组
 * @Author MatthewHan
 * @Date 2020/6/23 09:46
 * @Version 1.0
 **/
public class No905 {

    /**
     * 官方题解✔️
     * 原地双指针，这个最秀
     * 双指针，偶数从头开始插入，奇数从尾开始插入，遍历一次即可
     * @param arr
     * @return
     */
    public int[] sortArrayByParityByDoublePointer(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] % 2 > arr[j] % 2) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }

            if (arr[i] % 2 == 0) {
                i++;
            }
            if (arr[j] % 2 == 1) {
                j--;
            }
        }

        return arr;
    }


    /**
     * 利用 point 指针标记新数组的下标
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.3 MB , 在所有 Java 提交中击败了 85.71% 的用户
     *
     * @param arr
     * @return
     */
    public static int[] sortArrayByParityPro(int[] arr) {

        int[] temp = new int[arr.length];
        int point = 0;
        for (int item : arr) {
            if (item % 2 == 0) {
                temp[point] = item;
                point++;
            }
        }
        for (int value : arr) {
            if (value % 2 != 0) {
                temp[point] = value;
                point++;
            }
        }

        return temp;
    }

    /**
     * 原地修改
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 25.11% 的用户
     * 内存消耗： 40.6 MB , 在所有 Java 提交中击败了 71.43% 的用户
     *
     * @param arr
     * @return
     */
    public static int[] sortArrayByParity(int[] arr) {

        int evenCount = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
                stack.push(i);
            }
        }
        System.out.println(stack);

        for (int i = 0; i < arr.length; i++) {
            if (i < evenCount && arr[i] % 2 != 0) {
                int temp = arr[i];
                // 这里需要交换偶数下标数组的最后一个，不然当偶数在奇数后面就白交换了
                int index = stack.pop();
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0, 3, 1, 2, 0, 4, 1, 2, 3, 5, 7})));
    }
}
