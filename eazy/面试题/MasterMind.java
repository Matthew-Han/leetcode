package 面试题;

/**
 * @ClassName MasterMind
 * @Description 面试题 16.15. 珠玑妙算
 * @Author MatthewHan
 * @Date 2020/7/29 09:59
 * @Version 1.0
 **/
public class MasterMind {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 100.00% 的用户 炫耀一下:
     *
     * @param solution
     * @param guess
     * @return
     */
    public int[] masterMind(String solution, String guess) {
        int[] res = new int[2];
        int[] bucket1 = new int[26];
        int[] bucket2 = new int[26];
        for (int i = 0; i < 4; i++) {
            char tmp1 = solution.charAt(i);
            char tmp2 = guess.charAt(i);
            bucket1[tmp1 - 'A']++;
            bucket2[tmp2 - 'A']++;
            if (tmp1 == tmp2) {
                res[0]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            res[1] += Math.min(bucket1[i], bucket2[i]);
        }
        res[1] -= res[0];
        return res;
    }

}
