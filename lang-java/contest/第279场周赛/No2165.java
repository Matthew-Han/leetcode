package 第279场周赛;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/2/6 13:42 06
 * @since 1.0
 **/
public class No2165 {

    /**
     * 重排数字的最小值
     *
     * @param num
     * @return
     */
    public long smallestNumber(long num) {
        boolean flag = num < 0;
        num = Math.abs(num);
        Stream<Integer> objectStream = Arrays.stream(String.valueOf(num).split("")).map(Integer::valueOf);
        if (flag) {
            List<Integer> arr = objectStream.sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
            StringBuilder res = new StringBuilder();
            for (int i : arr) {
                res.append(i);
            }
            return -(Long.parseLong(res.toString()));
        } else {
            List<Integer> arr = objectStream.sorted().collect(Collectors.toList());
            if (arr.get(0) != 0) {
                StringBuilder res = new StringBuilder();
                for (int i : arr) {
                    res.append(i);
                }
                return Long.parseLong(res.toString());
            } else {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) != 0) {
                        arr.set(0, arr.get(i));
                        arr.set(i, 0);
                        break;
                    }
                }
                StringBuilder res = new StringBuilder();
                for (int i : arr) {
                    res.append(i);
                }
                return Long.parseLong(res.toString());
            }
        }
    }

}
