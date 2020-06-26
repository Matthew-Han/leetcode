/**
 * @ClassName DeleteColumns2MakeSorted
 * @Description #944 删列造序
 * @Author MatthewHan
 * @Date 2020/6/27 00:48
 * @Version 1.0
 **/
public class DeleteColumns2MakeSorted {

    /**
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 77.75% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 12.50% 的用户
     *
     * @param arr
     * @return
     */
    public static int minDeletionSize(String[] arr) {
        int count = 0;
        int len = arr[0].length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].charAt(i) > arr[j + 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }
}
