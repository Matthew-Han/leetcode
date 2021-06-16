import java.util.*;

/**
 * @ClassName PlusOne
 * @Description #66 加一
 * @Author MatthewHan
 * @Date 2020/4/14 11:38
 * @Version 1.0
 **/
public class No66 {


    public static int[] plusOne(int[] digits) {
        // list的容量大小为数组的长度+1，因为可能会进位。这样可以保证不用扩容。
        ArrayList<Integer> list = new ArrayList<>(digits.length + 1);
        for (int digit : digits) {
            list.add(digit);
        }
        int length = list.size() - 1;
        // 最后一位加1，如果是9的话，就变成了10
        list.set(length, list.get(length) + 1);
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            // 指针的第0位，其实源的末尾。
            if (list.get(i) == 10) {
                list.set(i, 0);
                // 下一位+1，如果下一位是9的话会变成10，指针会指向下一位，继续循环
                if (i + 1 < list.size()) {
                    list.set(i + 1, list.get(i + 1) + 1);
                }
                // 判断最后一位是否为0，为0说明是10，需要加一位在末尾，因为是翻转过的
                if (i + 1 == list.size() && list.get(i) == 0) {
                    list.add(1);
                }
            }

        }
        Collections.reverse(list);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println((Arrays.toString(plusOne(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}))));

    }
}
