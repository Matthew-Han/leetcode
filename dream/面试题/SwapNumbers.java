package 面试题;

/**
 * @ClassName SwapNumbers
 * @Description 面试题 16.01. 交换数字
 * @Author MatthewHan
 * @Date 2020/9/4 14:50
 * @Version 1.0
 **/
public class SwapNumbers {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 18.08% 的用户
     *
     * @param numbers
     * @return
     */
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
