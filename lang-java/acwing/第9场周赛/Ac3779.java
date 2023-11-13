package 第9场周赛;

import java.util.*;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/7/26 18:01
 * @since 1.0
 **/
public class Ac3779 {


    /**
     * 相等的和
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Map<Integer, List<Integer>>> fuck = new HashMap<>();
        Set<Integer> offer = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int[] arr = new int[k];
            int sum = 0;
            Set<Integer> v = new HashSet<>(k);
            for (int j = 0; j < k; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
                v.add(arr[j]);
            }
            for (int j = 0; j < k; j++) {
                offer.add(sum - arr[j]);
                fuck.put(sum - arr[j], fuck.getOrDefault(sum - arr[j], new HashMap<>()));
                Map<Integer, List<Integer>> v1 = fuck.get(sum - arr[j]);
                v1.put(i, v1.getOrDefault(i, new ArrayList<>()));
                List<Integer> v2 = v1.get(i);
                v2.add(j);
            }

        }
        List<Integer> cnt = new ArrayList<>();
        boolean flag = true;
        fuck:
        for (Integer o : offer) {
            Map<Integer, List<Integer>> v1 = fuck.get(o);
            if (v1 == null || v1.size() < 2) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                List<Integer> v2 = v1.get(j);
                if (v2 != null && v2.size() > 0) {
                    cnt.add(j + 1);
                    cnt.add(v2.get(0) + 1);
                    if (cnt.size() == 4) {
                        flag = false;
                        System.out.println("YES");
                        System.out.println(cnt.get(0) + " " + cnt.get(1));
                        System.out.println(cnt.get(2) + " " + cnt.get(3));
                        break fuck;
                    }
                }
            }
        }
        if (flag) {
            System.out.println("NO");
        }
    }
}
