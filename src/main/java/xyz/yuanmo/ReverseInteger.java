package xyz.yuanmo;

/**
 * @ClassName ReverseInteger
 * @Description 整数反转
 * @Author MatthewHan
 * @Date 2019/8/5 16:00
 * @Version 1.0
 **/
public class ReverseInteger {

    public static void main(String[] args){
        int x = 1113329932;
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(x));
    }

    /**
     * 该方法超慢的原因就是因为StringBuilder的append()方法
     * @param x
     * @return
     */
    public int reverse(int x) {
        try {
            if (x>=0){
                StringBuilder stringBuilder = new StringBuilder();
                String[] args = String.valueOf(x).split("");
                for(int i=args.length-1; i>=0; i--){
                    stringBuilder.append(args[i]);
                }
                return new Integer(stringBuilder.toString());
            }
            else {
                x = -x;
                StringBuilder stringBuilder = new StringBuilder();
                String[] args = String.valueOf(x).split("");
                for(int i=args.length-1; i>=0; i--){
                    stringBuilder.append(args[i]);
                }
                Integer str = new Integer(stringBuilder.toString());
                return -str;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }


    }
}
