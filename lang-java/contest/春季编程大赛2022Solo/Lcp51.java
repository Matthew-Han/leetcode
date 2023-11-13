package 春季编程大赛2022Solo;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/20 15:22 20
 * @since 1.0
 **/
public class Lcp51 {


    int max = -1;
    int[][] cookbooks;
    int[][] attribute;
    int limit;

    /**
     * 烹饪料理
     *
     * @param materials
     * @param cookbooks
     * @param attribute
     * @param limit
     * @return
     */
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        this.cookbooks = cookbooks;
        this.attribute = attribute;
        this.limit = limit;

        dfs(0, materials, 0, 0);


        return max;
    }

    public void dfs(int idx, int[] materials, int currSum, int currLimit) {
        if (currLimit >= limit) {
            max = Math.max(max, currSum);
        }
        if (idx >= cookbooks.length) {
            return;
        }
        int[] curr = cookbooks[idx];
        boolean f = check(materials, curr);
        dfs(idx + 1, materials, currSum, currLimit);
        if (f) {
            materials[0] -= curr[0];
            materials[1] -= curr[1];
            materials[2] -= curr[2];
            materials[3] -= curr[3];
            materials[4] -= curr[4];
            dfs(idx + 1, materials, currSum + attribute[idx][0], currLimit + attribute[idx][1]);
            materials[0] += curr[0];
            materials[1] += curr[1];
            materials[2] += curr[2];
            materials[3] += curr[3];
            materials[4] += curr[4];
        }
    }

    public boolean check(int[] materials, int[] cookbook) {
        for (int i = 0; i < 5; i++) {
            if (materials[i] < cookbook[i]) {
                return false;
            }
        }
        return true;
    }

}
