import java.util.*;

/**
 * @ClassName LargestTime4GivenDigits
 * @Description #949 给定数字能组成的最大时间
 * @Author MatthewHan
 * @Date 2020/6/27 01:07
 * @Version 1.0
 **/
public class No949 {


    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{0, 0, 0, 6}));

    }

    /**
     * 执行用时： 14 ms , 在所有 Java 提交中击败了 28.13% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param arr
     * @return
     */
    public static String largestTimeFromDigits(int[] arr) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    for (int k = 0; k < arr.length; k++) {
                        if (j != k && i != k) {
                            String temp = "" + arr[i] + arr[j] + arr[k] + arr[6 - i - j - k];
                            if (verify(temp)) {
                                set.add(temp);
                            }

                        }
                    }
                }

            }
        }
        System.out.println("set = " + set);
        if (set.size() == 0) {
            return "";
        }
        int max = Integer.MIN_VALUE;
        StringBuilder result = new StringBuilder();
        String maxStr = null;
        for (String s : set) {
            if (max < Integer.parseInt(s)) {
                max = Integer.parseInt(s);
                maxStr = s;
            }
        }
        System.out.println(max);

        result.append(maxStr.charAt(0)).append(maxStr.charAt(1)).append(":").append(maxStr.charAt(2)).append(maxStr.charAt(3));

        return result.toString();


    }


    /**
     * 判断是否符合24小时制
     * char类型判断
     *
     * @param dateTime
     * @return
     */
    public static boolean verify(String dateTime) {
        // 第一位最大是2
        if (dateTime.charAt(0) > '2') {
            return false;
        }
        /*
         * 当第一位是2时，第二位最大是3
         * 当第一位小于2是，第二位就无所谓啦~
         */
        if (dateTime.charAt(0) == '2' && dateTime.charAt(1) > '3') {
            return false;
        }
        // 第三位最大是5
        return dateTime.charAt(2) <= '5';
    }


}
