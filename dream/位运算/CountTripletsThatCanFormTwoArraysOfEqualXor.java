package 位运算;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/18 09:47
 * @description
 * @since 1.0.0
 **/
public class CountTripletsThatCanFormTwoArraysOfEqualXor {

    /**
     * #1442 形成两个异或相等数组的三元组数目
     *
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                a ^= arr[j];
                int b = arr[j];
                for (int k = j; k < arr.length; k++) {
                    b ^= arr[k];
                    if (a == b) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static int countTripletsPro(int[] arr) {
        int ans = 0;
        int sum = 0;
        // 因为数组内的元素 > 0，所以可以先用 size = 1 进入循环来计算 sum
        // 不然会有问题
        int size = 1;
        while (size <= arr.length) {
            sum ^= arr[size - 1];
            int tmp = sum;
            if (tmp == 0) {
                ans += size - 1;
            }
            for (int i = size; i < arr.length; i++) {
                tmp ^= arr[i - size];
                tmp ^= arr[i];
                if (tmp == 0) {
                    ans += size - 1;
                }
            }
            size++;
        }
        return ans;
    }

}
