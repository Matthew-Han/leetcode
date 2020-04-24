/**
 * @ClassName CountAndSay
 * @Description #38 外观数列
 * @Author MatthewHan
 * @Date 2020/4/13 09:59
 * @Version 1.0
 **/
public class CountAndSay {


    /**
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 6.     312211
     * 7.     13112221
     * 8.     1113213211
     * @param n
     * @return
     */
     public static String countAndSay(int n) {
        //n=1时最简单不用考虑
        if(n==1) {
            return "1";
        }
        String str="1";
        //当n为2及以上时。因为下一个数列是对上面的解释。所以用三个变量，一个代表数量count ,一个代表前一个数字pre，一个代表后一个数字back
        for(int i=2;i<=n;i++){  //大循环，n==？就循环几次
            StringBuilder builder = new StringBuilder();
            int count=1;
            // 大循环下面pre作为首数字，因为必须从第一个开始往后循环嘛，不然就遗漏了
            char pre = str.charAt(0);
            for (int j = 1; j < str.length(); j++) {
                char back = str.charAt(j);//后一个数字
                if (back == pre) {//相等count+1
                    count++;
                } else {
                    builder.append(count).append(pre);
                    //不等则append几个pre
                    pre = back;
                    count = 1;//count重置
                }
            }
            builder.append(count).append(pre);//这一步是因为上层循环结束点在n-1的地方停了。并没有把最后的back加入到builder里面。并且观察数字，最后一位永远是1.所以可以直接把1个1加入到builder中。
            str = builder.toString();//因为方法体的数据类型是Stirng所以必须转换成String型的数据才能返回。
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }



}
