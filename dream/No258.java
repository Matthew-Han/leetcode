/**
 * @ClassName AddDigits
 * @Description #258 各位相加
 * @Author MatthewHan
 * @Date 2020/5/6 13:58
 * @Version 1.0
 **/
public class No258 {

    /**
     * 执行用时 : 11 ms , 在所有 Java 提交中击败了 5.22% 的用户
     * 内存消耗 : 38.7 MB , 在所有 Java 提交中击败了 8.00% 的用户
     *
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        while (num >= 10) {
            String[] nums = String.valueOf(num).split("");
            num = 0;
            for (String s : nums) {
                num += Integer.parseInt(s);
            }
        }
        return num;
    }


    /**
     * 递归
     * 执行用时 : 11 ms , 在所有 Java 提交中击败了 5.22% 的用户
     * 内存消耗 : 38.6 MB , 在所有 Java 提交中击败了 8.00% 的用户
     *
     * @param num
     * @return
     */
    public static int addDigitsPro(int num) {
        if (num < 10) {
            return num;
        } else {
            String[] nums = String.valueOf(num).split("");
            num = 0;
            for (String s : nums) {
                num += Integer.parseInt(s);
            }

        }
        return addDigitsPro(num);
    }

    /**
     * 要记住整数的每一位遍历可以除以10！！！
     * 不要在用转字符串啦
     * 老是忘记！！！
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37 MB , 在所有 Java 提交中击败了 8.00% 的用户
     *
     * @param num
     * @return
     */
    public static int addDigitsMath(int num) {
        int result = 0;
        if (num < 10) {
            return num;
        } else {
            while (num > 0) {
                result += num % 10;
                num = num / 10;
            }
        }
        return addDigitsMath(result);
    }

}
