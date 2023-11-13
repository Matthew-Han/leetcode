package 第252场周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/2 09:46
 * @since 1.0
 **/
public class No1953 {

    /**
     * 你可以工作的最大周数
     *
     * @param milestones
     * @return
     */
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        long f = milestones[milestones.length - 1];
        long sum = 0;
        for (int i = 0; i < milestones.length - 1; i++) {
            sum += milestones[i];
        }
        if (f <= sum) {
            return f + sum;
        } else {
            return sum * 2 + 1;
        }

    }
}
