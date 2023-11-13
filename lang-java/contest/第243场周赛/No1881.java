package 第243场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/30 23:36
 * @description
 * @since 1.0.0
 **/
public class No1881 {

    /**
     * #1881 插入后的最大值
     *
     * @param n
     * @param x
     * @return
     */
    public String maxValue(String n, int x) {
        boolean positive = n.charAt(0) != '-';
        char[] nn = n.toCharArray();
        int index = 0;
        StringBuilder sb = new StringBuilder(n);
        if (positive) {
            boolean flag = true;
            for (int i = 0; i < nn.length; i++) {
                if (nn[i] - '0' < x) {
                    flag = false;
                    index = i;
                    break;
                }
            }
            if (flag) {
                index = nn.length;
            }
        } else {
            boolean flag = true;
            for (int i = 1; i < nn.length; i++) {
                if (nn[i] - '0' > x) {
                    flag = false;
                    index = i;
                    break;
                }
            }
            if (flag) {
                index = nn.length;
            }

        }
        sb.insert(index, x);
        return sb.toString();

    }
}
