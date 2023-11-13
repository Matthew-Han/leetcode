package 设计题;


import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/26 10:01 26
 * @since 1.0
 **/
public class No2013 {

    Map<String, Integer> cntMap;
    Map<Integer, Set<Integer>> xMap;
    Map<Integer, Set<Integer>> yMap;

    /**
     * 检测正方形
     */
    public No2013() {
        this.cntMap = new HashMap<>();
        this.xMap = new HashMap<>();
        this.yMap = new HashMap<>();
    }

    public void add(int[] point) {
        cntMap.put(point[0] + " " + point[1], cntMap.getOrDefault(point[0] + " " + point[1], 0) + 1);
        xMap.put(point[0], xMap.getOrDefault(point[0], new HashSet<>()));
        xMap.get(point[0]).add(point[1]);
        yMap.put(point[1], yMap.getOrDefault(point[1], new HashSet<>()));
        yMap.get(point[1]).add(point[0]);
    }

    public int count(int[] point) {
        int ans = 0;
        int x = point[0];
        int y = point[1];
        Set<Integer> xList = xMap.getOrDefault(x, new HashSet<>());
        Set<Integer> yList = yMap.getOrDefault(y, new HashSet<>());
        for (int yy : xList) {
            for (int xx : yList) {
                if (Math.abs(x - xx) == Math.abs(y - yy) && Math.abs(x - xx) != 0) {
                    ans += cntMap.getOrDefault(xx + " " + yy, 0) * cntMap.getOrDefault(point[0] + " " + yy, 1) * cntMap.getOrDefault(xx + " " + point[1], 1);
                }
            }
        }
        return ans;
    }

}
