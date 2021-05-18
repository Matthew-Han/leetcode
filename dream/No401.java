import java.util.*;

/**
 * @ClassName BinaryWatch
 * @Description #401 二进制手表
 * @Author MatthewHan
 * @Date 2020/5/12 16:54
 * @Version 1.0
 **/
public class No401 {


    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        // 直接遍历  0:00 -> 12:00   每个时间有多少1
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (count1(i) + count1(j) == num) {
                    res.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return res;
    }

    /**
     * 计算二进制中1的个数
     * 因为手表的时和分都是2的幂次方
     *
     * @param n
     * @return
     */
    int count1(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }


}
