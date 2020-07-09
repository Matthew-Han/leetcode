/**
 * @ClassName ElementAppearingMoreThan25PercentInSortedArray
 * @Description #1287 有序数组中出现次数超过25%的元素
 * @Author MatthewHan
 * @Date 2020/7/9 10:17
 * @Version 1.0
 **/
public class ElementAppearingMoreThan25PercentInSortedArray {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 41.67% 的用户
     *
     * @param arr
     * @return
     */
    public int findSpecialInteger(int[] arr) {
        int min = arr.length / 4;
        for (int i = 0; i < arr.length - min; i++) {
            if (arr[i] == arr[i + min]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
