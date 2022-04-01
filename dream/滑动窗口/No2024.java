package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/29 10:34 29
 * @since 1.0
 **/
public class No2024 {

    /**
     * 考试的最大困扰度
     *
     * @param answerKey
     * @param k
     * @return
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(ass(answerKey, k, 'T', 'F'), ass(answerKey, k, 'F', 'T'));
    }

    public int ass(String answerKey, int k, char a, char b) {
        char[] ak = answerKey.toCharArray();
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        int[] left = new int[ak.length];
        int[] right = new int[ak.length];
        int prev = 0;
        int tmp = 0;
        for (int i = 0; i < ak.length; i++) {
            if (ak[i] == a) {
                list.add(i);
                if (i > 0 && ak[i - 1] == b) {
                    left[i] = prev;
                }
                tmp++;
                prev = 0;
            } else {
                ans = Math.max(ans, tmp);
                tmp = 0;
                prev++;
            }
        }
        prev = 0;
        for (int i = ak.length - 1; i >= 0; i--) {
            if (ak[i] == a) {
                if (i < ak.length - 1 && ak[i + 1] == b) {
                    right[i] = prev;
                }
                prev = 0;
            } else {
                prev++;
            }
        }
        ans = Math.max(ans, tmp);
        for (int i = 0; i < list.size(); i++) {
            int l = list.get(i);
            int r = list.get(Math.min(i + k - 1, list.size() - 1));
            int sum = left[l] + (r - l + 1) + right[r];
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
