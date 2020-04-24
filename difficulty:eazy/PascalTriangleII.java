import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PascalTriangleII
 * @Description #119 杨辉三角 II
 * @Author MatthewHan
 * @Date 2020/4/17 17:23
 * @Version 1.0
 **/
public class PascalTriangleII {

    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 13.42% 的用户
     * 内存消耗 : 37.5 MB , 在所有 Java 提交中击败了 5.88% 的用户
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> fucker = new ArrayList<>(1);
        fucker.add(1);
        if (rowIndex == 0) {
            return fucker;
        }
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> nextFucker = new ArrayList<>(rowIndex);
            for (int j = 0; j < fucker.size(); j++) {
                if (j == 0) {
                    nextFucker.add(1);
                }
                if (j == fucker.size() - 1){
                    nextFucker.add(1);
                }
                if (j + 1 < fucker.size()){
                    nextFucker.add(fucker.get(j) + fucker.get(j + 1));
                }
            }
            fucker = nextFucker;
        }
        return fucker;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
