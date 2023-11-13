import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/7 10:28
 * @since 1.0
 **/
public class No1711 {

    Set<Integer> init;

    /**
     * 大餐计数
     *
     * @param deliciousness
     * @return
     */
    public int countPairs(int[] deliciousness) {
        long ans = 0L;
        init();
        int mod = 1000000000 + 7;
        Map<Integer, Integer> counter = new HashMap<>();
        Set<String> vis = new HashSet<>();
        for (int delicious : deliciousness) {
            counter.put(delicious, counter.getOrDefault(delicious, 0) + 1);
        }
        int[] newDeliciousness = new int[counter.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 1 && init.contains(entry.getKey() * 2)) {
                for (int i = 1; i < entry.getValue(); i++) {
                    ans += i % mod;
                }
            }
            newDeliciousness[index++] = entry.getKey();

        }
        ans %= mod;


        for (int delicious : newDeliciousness) {
            for (Integer fuck : init) {
                if (!vis.contains("" + delicious + (fuck - delicious)) && counter.containsKey(fuck - delicious) && fuck != 2 * delicious) {
                    vis.add("" + delicious + (fuck - delicious));
                    vis.add("" + (fuck - delicious) + delicious);
                    ans += (long) counter.get(delicious) * counter.get(fuck - delicious) % mod;
                }
            }
        }
        return (int) ans % mod;
    }

    public void init() {
        init = new HashSet<>();
        int n = 1;
        while (n <= 2097152) {
            init.add(n);
            n <<= 1;
        }
    }

}
