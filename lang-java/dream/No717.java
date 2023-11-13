/**
 * @ClassName OneBitAndTwoBitCharacters
 * @Description #717 1比特与2比特字符
 * @Author MatthewHan
 * @Date 2020/6/4 00:35
 * @Version 1.0
 **/
public class No717 {

    public boolean date20220222(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1 && i == bits.length - 2) {
                return false;
            } else if (bits[i] == 1) {
                i++;
            }
        }
        return true;
    }

    /**
     * 思路1：
     * <p>
     * 如果数组中间有一个0，那么之前多少个1都可以消掉，奇数个1可以和0组合抵消，偶数个1甚至不需要和0抵消。
     * 所以只要判断在末尾0前的1是奇数还是偶数就可以了:
     * 1. 奇数个1，必须和末尾0抵消，不满足条件`最后一个字符是一比特字符。`
     * 2. 偶数个1，多个`11`组合抵消。留下末尾0，完成条件。
     * <p>
     * 思路2：
     * 就是下面的代码啦~！
     * 去掉末尾0，逢1进2，逢0进1，代码有点写复杂了。
     * <p>
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 39.4 MB , 在所有 Java 提交中击败了 20.00% 的用户
     *
     * @param bits
     * @return
     */
    public static boolean isOneBitCharacter(int[] bits) {

        // 数组长度为2的特殊些情况的判断
        if (bits.length == 2 && bits[0] == 1 && bits[1] == 0) {
            return false;
        }
        int remaining = bits.length - 1;
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
                remaining -= 2;
            } else {
                i++;
                remaining--;
            }

            if (remaining == 1) {
                return bits[i] == 0;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{0, 0}));
    }
}
