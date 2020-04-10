package xyz.yuanmo;

/**
 * @ClassName ReverseInteger
 * @Description #7 整数反转
 * @Author MatthewHan
 * @Date 2019/8/5 16:00
 * @Version 1.0
 **/
public class ReverseInteger {

    public static void main(String[] args) {
        int x = -1129932;
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(x));
    }

    /**
     * 该方法不是很快的原因就是
     *
     * @param x
     * @return
     */
    private int reverse(int x) {
        try {
            if (x >= 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(x));
                return new Integer(sb.reverse().toString());
            } else {
                x = -x;
                StringBuilder sb = new StringBuilder(String.valueOf(x));
                Integer str = new Integer(sb.reverse().toString());
                return -str;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
