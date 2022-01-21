package 广度优先搜索;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/1/21 10:02 21
 * @since 1.0
 **/
public class No1345 {

    int[] arr;
    int[] mem;
    Map<Integer, PriorityQueue<Integer>> map;

    /**
     * 跳跃游戏 IV
     *
     * @param arr
     * @return
     */
    public int minJumps(int[] arr) {
        this.arr = arr;
        this.mem = new int[arr.length];
        this.map = new HashMap<>();
        Arrays.fill(mem, 0x3f3f3f3f);
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (prev != arr[i]) {
                map.put(arr[i], map.getOrDefault(arr[i], new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1))));
                map.get(arr[i]).offer(i);
                map.put(prev, map.getOrDefault(prev, new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1))));
                map.get(prev).offer(i - 1);
                prev = arr[i];
            } else {
                if (i == arr.length - 1) {
                    map.put(arr[i], map.getOrDefault(arr[i], new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1))));
                    map.get(arr[i]).offer(i);
                }
            }
        }
        map.remove(Integer.MIN_VALUE);
        return bfs();
    }

    public int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int cnt = 0;
        while (!q.isEmpty()) {
            int limit = q.size();
            for (int i = 0; i < limit; i++) {
                int idx = q.poll();
                if (idx == arr.length - 1) {
                    return cnt;
                }
                int val = arr[idx];
                PriorityQueue<Integer> idxs = map.get(val);
                if (idx - 1 >= 0) {
                    idxs.offer(idx - 1);
                }
                if (idx + 1 < arr.length) {
                    idxs.offer(idx + 1);
                }
                while (!idxs.isEmpty()) {
                    int newIdx = idxs.poll();
                    if (mem[newIdx] > cnt) {
                        mem[newIdx] = cnt;
                        q.offer(newIdx);
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}
