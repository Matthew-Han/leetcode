import java.util.Arrays;

/**
 * @ClassName DecompressRunLengthEncodedList
 * @Description #1313 解压缩编码列表
 * @Author MatthewHan
 * @Date 2020/7/10 10:48
 * @Version 1.0
 **/
public class No1313 {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.84% 的用户
     * 内存消耗： 40.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public static int[] decompressRLElist(int[] nums) {
        int count = 0;
        int len = nums.length / 2;
        int[] freq = new int[len];
        int[] val = new int[len];
        for (int i = 0; i < len * 2; i++) {
            if ((i & 1) == 0) {
                count += nums[i];
                freq[i / 2] = nums[i];
            } else {
                val[i / 2] = nums[i];
            }
        }

        int index = 0;
        int i = 0;
        int[] result = new int[count];
        while (index < len) {
            int freqTemp = freq[index];
            int valTemp = val[index];
            for (int j = 0; j < freqTemp; j++) {
                result[i] = valTemp;
                i++;
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
