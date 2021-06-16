package sort;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @description
 * @date 2021/4/21 17:06
 * @since 1.0.0
 **/
public class QuickSort<T extends Comparable<T>> implements ISort<T> {
    /**
     * 快速排序
     *
     * @param arr
     */
    @Override
    public void sort(T[] arr) {

        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public void quickSort(T[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        T pivot = arr[i];
        while (i < j) {
            while (i < j && arr[j].compareTo(pivot) >= 0) {
                j--;
            }
            if (i < j && arr[j].compareTo(pivot) < 0) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i].compareTo(pivot) < 1) {
                i++;
            }
            if (i < j && arr[i].compareTo(pivot) > 0) {
                arr[j] = arr[i];
                j--;
            }
        }
        if (i == j) {
            arr[i] = pivot;
        }
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
        System.out.println("arr = " + Arrays.toString(arr));

    }

    public static void main(String[] args) {
        QuickSort<Integer> demo = new QuickSort<>();
        demo.sort(new Integer[]{4, 5, 1, 1, 0, 2, 3, 3, 3, 33, 2, -1, 2, -111, 111});
    }
}
