package 双指针;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/3/4 11:10 04
 * @since 1.0
 **/
public class No2105 {

    /**
     * 给植物浇水 II
     *
     * @param plants
     * @param capacityA
     * @param capacityB
     * @return
     */
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int len = plants.length;
        int l = 0;
        int r = len - 1;
        int cl = capacityA;
        int cr = capacityB;
        while (l < r) {
            if (cl < plants[l]) {
                ans++;
                cl = capacityA - plants[l];
            } else {
                cl -= plants[l];
            }
            if (cr < plants[r]) {
                ans++;
                cr = capacityB - plants[r];
            } else {
                cr -= plants[r];
            }
            l++;
            r--;
        }
        if (len % 2 != 0) {
            if (Math.max(cl, cr) < plants[len / 2]) {
                ans++;
            }
        }
        return ans;
    }
}
