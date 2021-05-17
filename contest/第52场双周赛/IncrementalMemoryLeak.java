package 第52场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/15 22:11
 * @description
 * @since 1.0.0
 **/
public class IncrementalMemoryLeak {


    /**
     * #5743 增长的内存泄露
     *
     * @param memory1
     * @param memory2
     * @return
     */
    public int[] memLeak(int memory1, int memory2) {
        int[] ans = new int[3];
        int max = Integer.MAX_VALUE;
        int full = Math.max(memory1, memory2);
        for (int i = 1; i < max; i++) {
            if (full < i) {
                ans[0] = i;
                ans[1] = memory1;
                ans[2] = memory2;
                return ans;
            } else {
                if (full == memory1) {
                    memory1 -= i;
                } else {
                    memory2 -= i;
                }
            }
            full = Math.max(memory1, memory2);
        }
        return ans;
    }

}
