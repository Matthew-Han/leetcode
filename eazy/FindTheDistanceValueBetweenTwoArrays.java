import java.util.Comparator;

/**
 * @ClassName FindTheDistanceValueBetweenTwoArrays
 * @Description #1385 两个数组间的距离值
 * @Author MatthewHan
 * @Date 2020/7/13 10:04
 * @Version 1.0
 **/
public class FindTheDistanceValueBetweenTwoArrays {


    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 14.63% 的用户
     * 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr1
     * @param arr2
     * @param d
     * @return
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int count = 0;
        for (int value : arr1) {
            int temp = 0;
            for (Integer integer : arr2) {
                if (Math.abs(value - integer) <= d) {
                    break;
                } else {
                    temp++;
                }
            }
            if (temp == arr2.length) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {

    }
}

class Cmp1385 implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
    }
}