package design;

import java.util.Arrays;

/**
 * @ClassName KthLargestElementInaStream
 * @Description #703 数据流中的第K大元素
 * @Author MatthewHan
 * @Date 2020/5/29 16:47
 * @Version 1.0
 **/
public class KthLargestElementInaStream {


    private int len;
    private int[] data;
    private final int index;

    /**
     * 执行用时 : 852 ms , 在所有 Java 提交中击败了 6.33% 的用户
     * 内存消耗 : 47.2 MB , 在所有 Java 提交中击败了 87.50% 的用户
     *
     * @param k
     * @param nums
     */
    public KthLargestElementInaStream(int k, int[] nums) {
        index = k;
        len = nums.length;
        data = nums;
    }

    public int add(int val) {
        len++;
        int[] temp = new int[len];
        System.arraycopy(data, 0, temp, 0, data.length);
        temp[len - 1] = val;
        Arrays.sort(temp);
        data = new int[len];
        System.arraycopy(temp, 0, data, 0, temp.length);
        return data[len - index];

    }

    public static void main(String[] args) {
        KthLargestElementInaStream kth = new KthLargestElementInaStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
        System.out.println(kth.add(4));

    }
}
