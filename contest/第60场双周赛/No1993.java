package 第60场双周赛;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/9/6 17:51
 * @since 1.0
 **/
public class No1993 {

    boolean flag = false;
    Map<Integer, List<Integer>> map;
    Map<Integer, Integer> lockMap;
    Map<Integer, List<Integer>> fuckMap;

    /**
     * 树上的操作
     *
     * @param parent
     */
    public No1993(int[] parent) {

        map = new HashMap<>();
        lockMap = new HashMap<>();
        fuckMap = new HashMap<>();
        map.put(0, new ArrayList<>());
        lockMap.put(0, -1);
        for (int i = 1; i < parent.length; i++) {
            map.put(parent[i], map.getOrDefault(parent[i], new ArrayList<>()));
            map.get(parent[i]).add(i);
            lockMap.put(i, -1);
        }
        fuckMap.put(0, Collections.singletonList(0));
        init(map, 0);
    }

    public boolean lock(int num, int user) {
        if (lockMap.get(num) == -1) {
            lockMap.put(num, user);
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (lockMap.get(num) == user && user != -1) {
            lockMap.put(num, -1);
            return true;
        }
        return false;
    }

    /**
     * 指定节点当前状态为未上锁。
     * 指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
     * 指定节点没有任何上锁的祖先节点。
     *
     * @param num
     * @param user
     * @return
     */
    public boolean upgrade(int num, int user) {
        // 指定节点上锁
        if (lockMap.get(num) != -1) {
            return false;
        }
        // 指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
        flag = false;
        dfs(map, num);
        if (!flag) {

            return false;
        }

        // 指定节点没有任何上锁的祖先节点。
        List<Integer> gList = fuckMap.get(num);
        for (Integer g : gList) {
            if (lockMap.get(g) != -1) {
                return false;
            }
        }
        List<Integer> list = new ArrayList<>();
        dfs(map, num, list);
        for (Integer integer : list) {
            lockMap.put(integer, -1);
        }

        lockMap.put(num, user);
        return true;

    }

    public void dfs(Map<Integer, List<Integer>> map, int curr) {
        if (!map.containsKey(curr)) {
            return;
        }
        List<Integer> next = map.get(curr);
        for (Integer n : next) {
            if (lockMap.get(n) != -1) {
                flag = true;
                return;
            } else {
                dfs(map, n);
            }
        }
    }

    public void init(Map<Integer, List<Integer>> map, int curr) {
        if (!map.containsKey(curr)) {
            return;
        }
        List<Integer> next = map.get(curr);
        for (Integer n : next) {
            List<Integer> v = new ArrayList<>(fuckMap.get(curr));
            v.add(n);
            fuckMap.put(n, v);
            init(map, n);
        }
    }

    public void dfs(Map<Integer, List<Integer>> map, int curr, List<Integer> list) {
        if (!map.containsKey(curr)) {
            return;
        }
        List<Integer> next = map.get(curr);
        for (Integer n : next) {
            list.add(n);
            dfs(map, n, list);
        }
    }
}
