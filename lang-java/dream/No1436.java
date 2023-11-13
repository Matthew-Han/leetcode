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
public class No1436 {

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param paths
     * @return
     */
    public String destCity(List<List<String>> paths) {
        String[] path = new String[paths.size()];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < paths.size(); i++) {
            List<String> temp = paths.get(i);
            path[i] = temp.get(1);
            set.add(temp.get(0));
        }
        for (String str : path) {
            if (!set.contains(str)) {
                return str;
            }
        }
        return "";
    }
}
