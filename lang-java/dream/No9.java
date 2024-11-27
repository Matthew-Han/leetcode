/**
 * @ClassName PalindromeNumber
 * @Description #9 回文数
 * @Author MatthewHan
 * @Date 2019/8/5 16:21
 * @Version 1.0
 **/
public class No9 {


    private boolean isPalindrome(int x) {
        String left, right;
        String str = String.valueOf(x);
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        } else {
            int length = str.length();
            if (length % 2 == 0) {
                left = str.substring(0, length / 2);
                right = str.substring(length / 2, length);
            } else {
                left = str.substring(0, length / 2);
                right = str.substring(length / 2 + 1, length);
            }
            StringBuilder sb = new StringBuilder(right);
            right = sb.reverse().toString();
            return right.equals(left);
        }

    }


}
