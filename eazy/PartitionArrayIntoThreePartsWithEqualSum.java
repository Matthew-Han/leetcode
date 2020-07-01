/**
 * @ClassName PartitionArrayIntoThreePartsWithEqualSum
 * @Description #1013 将数组分成和相等的三个部分
 * @Author MatthewHan
 * @Date 2020/7/1 15:56
 * @Version 1.0
 **/
public class PartitionArrayIntoThreePartsWithEqualSum {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 47.5 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param arr
     * @return
     */
    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int anInt : arr) {
            sum += anInt;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int c = sum / 3;

        // left，右边留2个
        int leftSum = 0;
        int leftIndex = 0;
        while (leftIndex < arr.length - 2) {
            leftSum += arr[leftIndex];
            leftIndex++;
            if (leftSum == c) {
                break;
            }
        }
        if (leftSum != c) {
            return false;
        }

        // right，左边留2个
        int rightSum = 0;
        int rightIndex = arr.length - 1;
        while (rightIndex > 1) {
            rightSum += arr[rightIndex];
            rightIndex--;
            if (rightSum == c) {
                break;
            }
        }

        // 中间没元素了，也GG了
        if (rightSum != c || rightIndex < leftIndex) {
            return false;
        }

        // 中间
        int middleSum = 0;
        while (leftIndex <= rightIndex) {
            middleSum += arr[leftIndex++];
        }
        System.out.println("middleSum = " + middleSum);

        return middleSum == c;

    }

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{1, -1, 1, -1}));


    }
}
