package 进制系列;

/**
 * @ClassName Base7
 * @Description #504 七进制数
 * @Author MatthewHan
 * @Date 2020/5/19 10:54
 * @Version 1.0
 **/
public class No504 {

    /**
     * 负数只要在前面加 "-"
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.67% 的用户
     * 内存消耗 : 36.7 MB , 在所有 Java 提交中击败了 7.14% 的用户
     *
     * @param num
     * @return
     */
    public static String convertToBase7(int num) {
        boolean isNegative = num < 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (num == 0) {
            return "0";
        }
        num = Math.abs(num);
        while (num > 0) {
            stringBuilder.append(num % 7);
            num /= 7;
        }
        stringBuilder.reverse();
        return isNegative ? stringBuilder.insert(0, "-").toString() : stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("convertToBase7(7) = " + convertToBase7(0));
    }
}
