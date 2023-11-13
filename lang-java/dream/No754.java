import java.util.Map;
import java.util.TreeMap;
import java.util.stream.LongStream;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/11/4 16:26 04
 * @since 1.0
 **/
public class No754 {
    static TreeMap<Long, Long> collect1;

    static TreeMap<Long, Long> collect2;

    static {
        collect1 = LongStream.range(1, (int) 1e5).collect(TreeMap::new, (map, value) -> map.put(map.lastEntry() == null ? value : map.lastEntry().getKey() + value, value), (o1, o2) -> {
        });

        collect2 = LongStream.range(1, (int) 1e5).collect(TreeMap::new, (map, value) -> map.put(map.firstEntry() == null ? -value : map.firstEntry().getKey() - value, -value), (o1, o2) -> {
        });

    }

    public int reachNumber(int target) {
        TreeMap<Long, Long> collect = target > 0 ? collect1 : collect2;
        Map.Entry<Long, Long> entry = target > 0 ? collect.ceilingEntry((long) target) : collect.floorEntry((long) target);
        Long key = entry.getKey();
        Long val = entry.getValue();
        while (true) {
            if ((key - target) % 2 == 0) {
                return Math.abs(val.intValue());
            }
            entry = target > 0 ? collect.ceilingEntry(val + key) : collect.floorEntry(val + key);
            key = entry.getKey();
            val = entry.getValue();
        }

    }

}
