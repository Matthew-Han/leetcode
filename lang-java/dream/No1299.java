/**
 * @ClassName ReplaceElementsWithGreatestElementOnRightSide
 * @Description #1299 将每个元素替换为右侧最大元素
 * @Author MatthewHan
 * @Date 2020/7/10 10:39
 * @Version 1.0
 **/
public class No1299 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 58.37% 的用户
     * 内存消耗： 40.9 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
        int[] temp = new int[arr.length];
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            max = Math.max(max, arr[i + 1]);
            temp[i] = max;
        }
        temp[temp.length - 1] = -1;
        return temp;
    }
}
