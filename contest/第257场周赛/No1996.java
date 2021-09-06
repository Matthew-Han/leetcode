package 第257场周赛;

import java.util.Arrays;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/6 17:53
 * @since 1.0
 **/
public class No1996 {

    /**
     * 游戏中弱角色的数量
     *
     * @param properties
     * @return
     */
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, ((o1, o2) -> Integer.compare(o1[0], o2[0])));
        int[] arr = new int[properties.length];
        int max = properties[properties.length - 1][1];
        for (int i = properties.length - 1; i >= 0; i--) {
            arr[i] = Math.max(properties[i][1], max);
            max = arr[i];
        }
        int ans = 0;
        for (int i = 0; i < properties.length; i++) {
            for (int j = i + 1; j < properties.length; j++) {
                if (arr[i] <= properties[i][1]) {
                    break;
                }
                if (properties[j][0] > properties[i][0] && arr[j] > properties[i][1]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
