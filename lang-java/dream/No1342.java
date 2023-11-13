/**
 * @ClassName NumberOfStepsToReduceaNumberToZero
 * @Description #1342 将数字变成 0 的操作次数
 * @Author MatthewHan
 * @Date 2020/7/10 23:28
 * @Version 1.0
 **/
public class No1342 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param num
     * @return
     */
    public static int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int count = 0;
        while (num > 2) {
            if ((num & 1) == 0) {
                num /= 2;
            } else {
                num--;
            }
            count++;
        }
        return count + 2;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(15));
        System.out.println(numberOfSteps(11));
        System.out.println(numberOfSteps(7));
        System.out.println(numberOfSteps(8));

    }
}
