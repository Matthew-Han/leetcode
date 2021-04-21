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
        //todo 等下回家写


    }

    public static void main(String[] args) {
        QuickSort<Integer> demo = new QuickSort<>();
        demo.sort(new Integer[]{3, 8, 1, 4, 5});
    }
}
