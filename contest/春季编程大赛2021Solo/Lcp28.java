package 春季编程大赛2021Solo;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/4/5 14:55
 **/
public class Lcp28 {

    long mod = 1000000000 + 7;

    /**
     * LCP #28 采购方案
     *
     * @param nums
     * @param target
     * @return
     */
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i];
            int d = target - curr;
            if (d < 0) {
                continue;
            }
            if (d < curr) {
                continue;
            }
            int index = func(nums, i + 1, d);
            ans += (index - i);
            ans %= mod;

        }
        return (int) (ans % mod);

    }

    public int func(int[] arr, int left, int d) {
        int right = arr.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == d) {
                int tIndex = mid;
                for (int i = mid + 1; i < arr.length; i++) {
                    if (arr[i] <= d) {
                        tIndex++;
                    } else {
                        break;
                    }
                }
                return tIndex;
            } else if (arr[mid] < d) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            ans = mid;
        }
        if (arr[ans] > d) {
            return left - 1;
        }
        if (ans + 1 < arr.length && arr[ans + 1] <= d) {
            return ans + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Lcp28 demo = new Lcp28();
        System.out.println(demo.purchasePlans(new int[]{1, 2, 3, 3, 5, 5}, 6));
    }
}
