/**
 * @ClassName LcOf03
 * @Description 剑指 Offer #03 数组中重复的数字
 * @Author MatthewHan
 * @Date 2020/7/16 14:44
 * @Version 1.0
 **/
public class L03 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 70.54% 的用户
     * 内存消耗： 47.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        boolean[] bucket = new boolean[100001];
        for (int num : nums) {
            if (bucket[num]) {
                return num;
            } else {
                bucket[num] = true;
            }
        }
        return -1;
    }

    /**
     * 一开始看错了，以为是求重复的数字有几个，原来是随便一个重复的就可
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberMain(int[] nums) {
        int count = 0;
        int[] bucket = new int[100001];
        for (int num : nums) {
            if (bucket[num] == 0) {
                bucket[num]++;
            } else if (bucket[num] == 1) {
                bucket[num]++;
                count++;
            }
        }
        return count;
    }

    /**
     * 这个异或解决两数交换太秀了
     *
     * @param args
     */
    public static void main(String[] args) {
        int a = 7;
        int b = 11;
        b = a ^ b;
        a = a ^ b;
        b = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
