package sort;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @description
 * @date 2021/4/21 15:00
 * @since 1.0.0
 **/
public class InsertionSort<T extends Comparable<T>> implements ISort<T> {
    /**
     * 插入排序
     *
     * @param arr
     */
    @Override
    public void sort(T[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (j + 1 < len && arr[i].compareTo(arr[j]) < 1) {
                    T tmp = arr[i];
                    System.arraycopy(arr, j, arr, j + 1, i - j);
                    arr[j] = tmp;
                    break;
                }
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));

    }

    public static void main(String[] args) {
        InsertionSort<Integer> demo = new InsertionSort<>();
        demo.sort(new Integer[]{4, 5, 1, 1, 0, 2, 3, 3, 3, 33, 2, -1, 2, -111, 111});
    }
}
