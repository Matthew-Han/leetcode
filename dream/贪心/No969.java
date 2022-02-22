package 贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/22 09:14 22
 * @since 1.0
 **/
public class No969 {

    /**
     * 煎饼排序
     *
     * @param arr
     * @return
     */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = search(arr, i + 1, i);
            if (idx != i) {
                swap(arr, 0, idx);
                ans.add(idx + 1);
                swap(arr, 0, i);
                ans.add(i + 1);
            }

        }
        return ans;
    }

    public int search(int[] arr, int target, int start) {
        for (int i = start; i >= 0; i--) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }


    public void swap(int[] arr, int l, int r) {
        for (int i = l; i <= r / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[r - i];
            arr[r - i] = temp;
        }
    }
}
