package dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName KeysAndRooms
 * @Description #841 钥匙和房间
 * @Author MatthewHan
 * @Date 2020/8/31 02:10
 * @Version 1.0
 **/
public class KeysAndRooms {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 96.65% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 10.67% 的用户
     *
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();
        // 0号房永远是你的sweetHome，所以要加0
        keys.add(0);
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, keys, 0);
        System.out.println("keys = " + keys);
        return keys.size() == rooms.size();
    }

    public static void dfs(List<List<Integer>> rooms, boolean[] visited, Set<Integer> keys, int index) {
        // 可以不用加这句，index < visited.length && ，应该不会出现不存在的房间的钥匙
        if (!visited[index]) {
            visited[index] = true;
            List<Integer> nextKeys = rooms.get(index);
            for (Integer nextKey : nextKeys) {
                keys.add(nextKey);
                dfs(rooms, visited, keys, nextKey);
            }

        }
    }

}
