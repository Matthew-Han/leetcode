package 位运算;

/**
 * @ClassName 进制系列.ReverseBits
 * @Description #190 颠倒二进制位
 * @Author MatthewHan
 * @Date 2020/4/24 16:45
 * @Version 1.0
 **/
public class No190 {

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += ((n >> i) & 1) == 1 ? 1 << (31 - i) : 0;
        }
        return ans;
    }
}
