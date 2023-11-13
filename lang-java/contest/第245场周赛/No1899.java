package 第245场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/6/16 15:22
 * @description
 * @since 1.0.0
 **/
public class No1899 {

    /**
     * #1899 合并若干三元组以形成目标三元组
     *
     * @param triplets
     * @param target
     * @return
     */
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for (int i = 0; i < 3; i++) {
            boolean flag = true;
            int index = 0;
            for (int j = 0; j < triplets.length; j++) {
                fuck:
                if (flag && triplets[j][i] == target[i]) {
                    for (int k = 0; k < 3; k++) {
                        // 如果当前符合的单个元素的其他元素比 target 中的要大的话，就没必要那这个去赋值了
                        if (triplets[j][k] > target[k]) {
                            break fuck;
                        }
                    }
                    flag = false;
                    index = j;
                }
                if (!flag) {
                    triplets[j][0] = Math.max(triplets[j][0], triplets[index][0]);
                    triplets[j][1] = Math.max(triplets[j][1], triplets[index][1]);
                    triplets[j][2] = Math.max(triplets[j][2], triplets[index][2]);
                }
            }
        }
        for (int[] triplet : triplets) {
            int cnt = 0;
            for (int i = 0; i < triplet.length; i++) {
                if (triplet[i] == target[i]) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                return true;
            }
        }
        return false;
    }

}
