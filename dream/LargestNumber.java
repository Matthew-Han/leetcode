import java.util.Arrays;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/14 09:37
 **/
public class LargestNumber {

    /**
     * #179 最大数
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        Integer[] tmp = new Integer[nums.length];
        int count0 = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
            count0 += nums[i] == 0 ? 1 : 0;
        }
        if (count0 == nums.length) {
            return "0";
        }
        Arrays.sort(tmp, (o1, o2) -> {
            char[] o1o2 = (o1 + "" + o2).toCharArray();
            char[] o2o1 = (o2 + "" + o1).toCharArray();
            for (int i = 0; i < o2o1.length; i++) {
                if (o1o2[i] < o2o1[i]) {
                    return 1;
                } else if (o1o2[i] > o2o1[i]) {
                    return -1;
                }
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (Integer t : tmp) {
            sb.append(t);
        }

        return sb.toString();
    }
}
