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
    private final int[] oldData;
    private int[] newData;
    private final int index;

    public KthLargestElementInaStream(int k, int[] nums) {
        index = k;
        len = nums.length;
        oldData = nums;

    }

    public int add(int val) {
        len++;
        newData = new int[len];
        System.arraycopy(oldData, 0, newData, 0, oldData.length);
        newData[len - 1] = val;
        Arrays.sort(newData);
        return newData[len - index];

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
