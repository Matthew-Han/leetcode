package 桶排序;

/**
 * @ClassName UniqueNumberOfOccurrences
 * @Description #1207 独一无二的出现次数
 * @Author MatthewHan
 * @Date 2020/7/8 09:34
 * @Version 1.0
 **/
public class UniqueNumberOfOccurrences {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 91.53% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 5.88% 的用户
     *
     * @param arr
     * @return
     */
    public static boolean uniqueOccurrences(int[] arr) {
        int[] bucket = new int[2001];
        for (int n : arr) {
            // 因为-1000 <= arr[i] <= 1000，所以要+1000
            bucket[n + 1000]++;
        }
        int[] bucket2 = new int[1000];
        for (int n : bucket) {
            // 有记录的才在桶2自增
            if (n > 0) {
                bucket2[n]++;
            }
        }
        for (int i = bucket2.length - 1; i >= 0; i--) {
            if (bucket2[i] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }

}
