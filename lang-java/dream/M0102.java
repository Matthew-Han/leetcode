import java.util.Arrays;

/**
 * @ClassName CheckPermutation
 * @Description 面试题 01.02. 判定是否互为字符重排
 * @Author MatthewHan
 * @Date 2020/7/23 11:12
 * @Version 1.0
 **/
public class M0102 {


    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutation(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));

        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("abccca", "ccaabc"));
    }


}
