/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2021/5/14 23:46
 * @description
 * @since 1.0.0
 **/
public class No12 {

    /**
     * #12 整数转罗马数字
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 88.72% 的用户
     * 内存消耗： 37.2 MB , 在所有 Java 提交中击败了 99.78% 的用户
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num <= 9) {
            build(num, 1, sb);
        } else if (num <= 99) {
            build(num % 10, 1, sb);
            build(num / 10, 2, sb);
        } else if (num <= 999) {
            build(num % 10, 1, sb);
            num /= 10;
            build(num % 10, 2, sb);
            build(num / 10, 3, sb);
        } else {
            build(num % 10, 1, sb);
            num /= 10;
            build(num % 10, 2, sb);
            num /= 10;
            build(num % 10, 3, sb);
            build(num / 10, 4, sb);
        }
        return sb.toString();
    }

    public void build(int c, int bit, StringBuilder sb) {
        if (bit == 1) {
            if (c < 4) {
                while (c > 0) {
                    sb.insert(0, "I");
                    c--;
                }

            } else if (c == 4) {
                sb.insert(0, "IV");
            } else if (c < 9) {
                while (c > 5) {
                    sb.insert(0, "I");
                    c--;
                }
                sb.insert(0, "V");
            } else {
                sb.insert(0, "IX");
            }
        } else if (bit == 2) {
            if (c < 4) {
                while (c > 0) {
                    sb.insert(0, "X");
                    c--;
                }

            } else if (c == 4) {
                sb.insert(0, "XL");
            } else if (c < 9) {
                while (c > 5) {
                    sb.insert(0, "X");
                    c--;
                }
                sb.insert(0, "L");
            } else {
                sb.insert(0, "XC");
            }
        } else if (bit == 3) {
            if (c < 4) {
                while (c > 0) {
                    sb.insert(0, "C");
                    c--;
                }

            } else if (c == 4) {
                sb.insert(0, "CD");
            } else if (c < 9) {
                while (c > 5) {
                    sb.insert(0, "C");
                    c--;
                }
                sb.insert(0, "D");
            } else {
                sb.insert(0, "CM");
            }
        } else {
            while (c > 0) {
                sb.insert(0, "M");
                c--;
            }
        }
    }
}
