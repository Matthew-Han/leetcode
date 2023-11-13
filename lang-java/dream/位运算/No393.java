package 位运算;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/14 16:39 14
 * @since 1.0
 **/
public class No393 {

    /**
     * UTF-8 编码验证
     *
     * @param data
     * @return
     */
    public boolean validUtf8(int[] data) {
        int bits = 1;
        for (int datum : data) {
            int[] c = binary(datum);
            if (bits <= 1) {
                bits = bits(c);
                if (bits > 4 || bits == 1) {
                    return false;
                }
                continue;
            }
            bits--;
            if (c[0] != 1 || c[1] != 0) {
                return false;
            }
        }
        return data.length == 1 ? binary(data[0])[0] == 0 : bits <= 1;
    }

    public int bits(int[] c) {
        int bits = 0;
        for (int j : c) {
            if ((1 & j) == 0) {
                break;
            } else {
                bits++;
            }
        }
        return bits;
    }

    public int[] binary(int d) {
        int[] ans = new int[8];
        int idx = 7;
        while (d != 0) {
            ans[idx--] = d % 2;
            d /= 2;
        }
        return ans;
    }
}
