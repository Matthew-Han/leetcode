package 贪心;

import java.util.*;

/**
 * @ClassName QueueReconstructionByHeight
 * @Description #406 根据身高重建队列
 * @Author MatthewHan
 * @Date 2020/8/30 23:37
 * @Version 1.0
 **/
public class No406 {

    /**
     * 执行用时： 51 ms , 在所有 Java 提交中击败了 5.02% 的用户
     * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 5.09% 的用户
     *
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        List<int[]> temp = new ArrayList<>();
        List<int[]> set = new ArrayList<>();
        for (int[] person : people) {
            if (person[1] == 0) {
                temp.add(person);
            } else {
                set.add(person);
            }
        }
        temp.sort(new Sort1());
        set.sort(new Sort2());
        while (!set.isEmpty()) {
            for (int i = set.size() - 1; i >= 0; i--) {
                int[] curr = set.get(i);
                int index = check(curr, temp);
                if (index != -1) {
                    temp.add(index, curr);
                    set.remove(i);
                }
            }
        }
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }

    public static int check(int[] tmp, List<int[]> res) {
        int left = tmp[0];
        int right = tmp[1];
        int count = 0;
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i)[0] >= left) {
                count++;
            }
            if (count == right) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(reconstructQueue(input)));

    }
}

class Sort1 implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
    }
}

/**
 * 这道题的排序很狗的
 * 反正这么排
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 第二位不是 0 的，先按第二位顺序（从小到大），再按第一位逆序（从大到小）
 * 所以排序好是（[7,1],[6,1],[5,2],[4,4]）
 * 因为在代码中是 forr（要删除元素，所以又逆了一下。）
 */
class Sort2 implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o2[1] != o1[1]) {
            return Integer.compare(o2[1], o1[1]);
        } else {
            return Integer.compare(o1[0], o2[0]);
        }
    }
}