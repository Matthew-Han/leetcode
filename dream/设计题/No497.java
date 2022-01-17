package 设计题;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/17 09:20
 * @since 1.0
 **/
public class No497 {


    int max;
    int[][] rects;
    TreeMap<Integer, Integer> map;

    /**
     * 非重叠矩形中的随机点
     *
     * @param rects
     */
    public No497(int[][] rects) {
        int prev = 0;
        this.rects = rects;
        this.map = new TreeMap<>();
        for (int i = 0; i < rects.length; i++) {
            int curr = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            map.put(curr + prev, i);
            prev += curr;
            this.max = prev;
        }
    }

    public int[] pick() {
        Map.Entry<Integer, Integer> e = map.higherEntry(new Random().nextInt(max));
        Integer idx = e.getValue();
        int[] rect = rects[idx];
        int x = 0;
        int y = 0;
        for (int i = rect[0]; i <= rect[2]; i++) {
            if (ThreadLocalRandom.current().nextInt(i - rect[0] + 1) == 0) {
                x = i;
            }
        }
        for (int i = rect[1]; i <= rect[3]; i++) {
            if (ThreadLocalRandom.current().nextInt(i - rect[1] + 1) == 0) {
                y = i;
            }
        }
        return new int[]{x, y};
    }


}
