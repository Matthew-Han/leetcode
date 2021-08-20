/**
 * @ClassName ReverseStringII
 * @Description #541 反转字符串 II
 * @Author MatthewHan
 * @Date 2020/5/20 14:33
 * @Version 1.0
 **/
public class No541 {


    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int left = 0;
        while (left < arr.length) {
            if (left + k >= arr.length) {
                int right = arr.length;
                for (int i = left; i < left + (arr.length - left) / 2; i++) {
                    arr[i] ^= arr[right - 1];
                    arr[right - 1] ^= arr[i];
                    arr[i] ^= arr[right - 1];
                    right--;
                }
                break;
            } else {
                int right = left + k;
                for (int i = left; i < left + k / 2; i++) {
                    arr[i] ^= arr[right - 1];
                    arr[right - 1] ^= arr[i];
                    arr[i] ^= arr[right - 1];
                    right--;
                }
                left += 2 * k;
            }
        }
        return new String(arr);
    }
}
