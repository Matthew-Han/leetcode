package 第54场双周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 15:16
 * @description
 * @since 1.0.0
 **/
public class No1894 {

    /**
     * #1894 找到需要补充粉笔的学生编号
     *
     * @param chalk
     * @param k
     * @return
     */
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int c : chalk) {
            sum += c;
        }
        long diff = k % sum;
        if (diff == 0) {
            return 0;
        } else {
            for (int i = 0; i < chalk.length; i++) {
                if (diff < chalk[i]) {
                    return i;
                } else {
                    diff -= chalk[i];
                }
            }
        }
        return 0;
    }
}
