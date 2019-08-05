package xyz.yuanmo;

/**
 * @ClassName PalindromeNumber
 * @Description 回文数
 * @Author MatthewHan
 * @Date 2019/8/5 16:21
 * @Version 1.0
 **/
public class PalindromeNumber {

    public static void main(String[] args){
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(11011));
    }
    public boolean isPalindrome(int x) {
        String left,right;
        String str = String.valueOf(x);
        if (x<0){
            return false;
        }
        if (x<10) {
            return true;
        }
        else {
            int length = str.length();
            if(length%2==0){
                left = str.substring(0,length/2);
                right = str.substring(length/2,length);
            }
            else {
                left = str.substring(0,length/2);
                right = str.substring(length/2+1,length);
            }
            StringBuilder sb = new StringBuilder(right);
            right = sb.reverse().toString();
            return right.equals(left);
        }

    }

}
