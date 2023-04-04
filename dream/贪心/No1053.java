package 贪心;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2023/4/4 16:23 04
 * @since 1.0
 **/
public class No1053 {

    /**
     * 交换一次的先前排列
     *
     * @param arr
     * @return
     */
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length - 1;
        f:
        while (len-- >= 1) {
            for (int i = len; i < arr.length; i++) {
                if (i + 1 < arr.length && arr[i] > arr[i + 1]) {
                    int max = 0xc0c0c0c0;
                    int maxIndex = -1;
                    for (int j = arr.length - 1; j > i; j--) {
                        if (arr[j] >= max && arr[i] != arr[j] && arr[i] > arr[j]) {
                            maxIndex = j;
                            max = arr[j];
                        }
                    }
                    if (maxIndex != -1) {
                        arr[i] ^= arr[maxIndex];
                        arr[maxIndex] ^= arr[i];
                        arr[i] ^= arr[maxIndex];
                    }

                    break f;
                }
            }
        }
        return arr;
    }
}
