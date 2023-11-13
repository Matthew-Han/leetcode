package 第279场周赛;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/6 13:47 06
 * @since 1.0
 **/
public class No2166 {

    int t;
    int cnt0;
    int cnt1;
    Map<Integer, Integer> data;

    /**
     * 设计位集
     * <p>
     * 通过 idx 变换次数的奇偶性来判断当前标记位的值。
     * <p>
     * 其中 flip 方法，需要一个额外的参数 t 来存储一次全局的变换次数，这样可以做到只有 toString 方法需要 O(n) 的时间复杂度。
     *
     * @param size
     */
    public No2166(int size) {
        this.t = 0;
        this.cnt0 = size;
        this.cnt1 = 0;
        // 奇数 1 偶数 0
        this.data = new HashMap<>();
        for (int i = 0; i < size; i++) {
            data.put(i, 0);
        }
    }

    public void fix(int idx) {
        if ((data.get(idx) + t) % 2 == 0) {
            data.put(idx, data.get(idx) + 1);
            cnt0--;
            cnt1++;
        }
    }

    public void unfix(int idx) {
        if ((data.get(idx) + t) % 2 != 0) {
            data.put(idx, data.get(idx) + 1);
            cnt0++;
            cnt1--;
        }
    }

    public void flip() {
        this.t++;
        cnt0 ^= cnt1;
        cnt1 ^= cnt0;
        cnt0 ^= cnt1;
    }

    public boolean all() {
        return cnt0 == 0;
    }

    public boolean one() {
        return cnt1 > 0;
    }

    public int count() {
        return cnt1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt0 + cnt1; i++) {
            sb.append((data.get(i) + t) % 2 == 0 ? 0 : 1);
        }
        return sb.toString();
    }
}
