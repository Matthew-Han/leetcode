/**
 * @ClassName FindSmallestLetterGreaterThanTarget
 * @Description #744 寻找比目标字母大的最小字母
 * @Author MatthewHan
 * @Date 2020/6/6 00:48
 * @Version 1.0
 **/
public class FindSmallestLetterGreaterThanTarget {

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 11.11% 的用户
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c'}, 'b'));
    }
}
