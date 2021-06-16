import java.util.*;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/3/19 15:21
 **/
public class No692 {

    /**
     * #692 前K个高频单词
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 93.00% 的用户
     * 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 31.25% 的用户
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 小顶堆
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(k, (o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return -1;
            } else if (o1.getValue() > o2.getValue()) {
                return 1;
            } else {
                // 如果频次相同，单词的字母顺序反而应该排在后面，这样 poll() 的时候可以慢一点
                // 所以这个是o2 -> o1
                return fuckSort(o2.getKey(), o1.getKey());
            }

        });

        for (Map.Entry<String, Integer> set : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(set);
            } else {
                if (pq.peek().getValue() < set.getValue()) {
                    pq.poll();
                    pq.offer(set);
                } else if (pq.peek().getValue().equals(set.getValue())) {
                    if (fuckSort(pq.peek().getKey(), set.getKey()) == 1) {
                        pq.poll();
                        pq.offer(set);
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>(k);
        while (pq.size() > 0) {
            ans.add(0, pq.poll().getKey());
        }
        return ans;
    }

    public int fuckSort(String o1, String o2) {
        int min = Math.min(o1.length(), o2.length());
        for (int i = 0; i < min; i++) {
            if (o1.charAt(i) < o2.charAt(i)) {
                return -1;
            } else if (o1.charAt(i) > o2.charAt(i)) {
                return 1;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }

}
