import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName DestinationCity
 * @Description #1436 旅行终点站
 * @Author MatthewHan
 * @Date 2020/7/14 16:09
 * @Version 1.0
 **/
public class DestinationCity {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param paths
     * @return
     */
    public String destCity(List<List<String>> paths) {
        String[] path1 = new String[paths.size()];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < paths.size(); i++) {
            List<String> temp = paths.get(i);
            path1[i] = temp.get(1);
            set.add(temp.get(0));
        }
        for (String s1 : path1) {
            if (!set.contains(s1)) {
                return s1;
            }
        }
        return "";
    }

    public static void main(String[] args) {

    }
}
