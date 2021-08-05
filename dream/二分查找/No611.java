package 二分查找;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/4 17:06
 * @since 1.0
 **/
public class No611 {

    /**
     * 有效三角形的个数
     *
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int[] bucket = new int[1001];
        for (int n : nums) {
            bucket[n]++;
        }
        int ans = 0;
        for (int i = 1; i < 1001; i++) {
            if (bucket[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < 1001; j++) {
                if (bucket[j] == 0) {
                    continue;
                }
                for (int k = j + 1; k < 1001; k++) {
                    if (bucket[k] == 0) {
                        continue;
                    }
                    if (i + j > k) {
                        ans += bucket[i] * bucket[j] * bucket[k];
                    }
                }
            }
        }
        for (int i = 1; i < 1001; i++) {
            if (bucket[i] > 1) {
                for (int j = 1; j < 1001; j++) {
                    if (bucket[j] > 0 && i != j) {
                        if (i * 2 > j) {
                            int tmp = 1;
                            for (int k = bucket[i]; k > bucket[i] - 2; k--) {
                                tmp *= k;
                            }
                            ans += tmp / 2 * bucket[j];
                        }
                    }

                }
            }
        }
        for (int i = 1; i < 1001; i++) {
            if (bucket[i] > 2) {
                int tmp = 1;
                for (int j = bucket[i]; j > bucket[i] - 3; j--) {
                    tmp *= j;
                }
                ans += tmp / 6;
            }
        }
        return ans;
    }
}
