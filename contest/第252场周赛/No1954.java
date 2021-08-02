package 第252场周赛;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/8/2 09:47
 * @since 1.0
 **/
public class No1954 {

    /**
     * 收集足够苹果的最小花园周长
     *
     * @param neededApples
     * @return
     */
    public long minimumPerimeter(long neededApples) {
        long ans = 12;
        long depth = 1;
        while (ans < neededApples) {
            depth++;
            ans += depth * 3 * (depth + 1) / 2 * 8 - depth * 8 - depth * 4;

        }
        return depth * 8;
    }
}
