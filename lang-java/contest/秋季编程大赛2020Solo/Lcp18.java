package 秋季编程大赛2020Solo;

import java.util.Arrays;


/**
 * @ClassName Lcp18
 * @Description Lcp18
 * @Author MatthewHan
 * @Date 2020/9/12 14:52
 * @Version 1.0
 **/
public class Lcp18 {


    /**
     * Lcp #18 早餐组合
     *
     * @param staple
     * @param drinks
     * @param x
     * @return
     */
    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        int mod = 1000000007;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        long ans = 0;
        int right = drinks.length - 1;
        for (int s : staple) {
            int tmp = x - s;
            if (tmp < 0) {
                break;
            }
            if (right == 0 && x < drinks[0] + s) {
                break;
            }
            int left = 0;
            boolean flag = true;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (drinks[mid] == tmp) {
                    ans += mid + 1;
                    for (int i = mid + 1; i < drinks.length; i++) {
                        if (drinks[i] <= tmp) {
                            ans++;
                        } else {
                            break;
                        }
                    }
                    if (ans > mod) {
                        ans %= mod;
                    }
                    flag = false;
                    break;
                } else if (drinks[mid] < tmp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (flag) {
                ans += right + 1;
            }

            System.out.println("ans = " + ans);


        }
        return (int) ans % mod;

    }

    public static void main(String[] args) {

        System.out.println(breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 2, 5}, 15));
        System.out.println(breakfastNumber(new int[]{1, 4, 3, 23, 12, 12, 1, 2, 3, 1, 2, 1, 3, 1, 7}, new int[]{2, 6, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 1, 2, 3, 1, 8}, 9));

    }
}
