package sort;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @description
 * @date 2021/4/21 15:44
 * @since 1.0.0
 **/
public class BubbleSort<T extends Comparable<T>> implements ISort<T> {

    /**
     * 冒泡排序
     *
     * @param arr
     */
    @Override
    public void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) < 1) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        BubbleSort<Integer> demo = new BubbleSort<>();
        demo.sort(new Integer[]{4, 5, 1, 1, 0, 2, 3, 3, 3, 33, 2, -1, 2, -111, 111});
    }
}
