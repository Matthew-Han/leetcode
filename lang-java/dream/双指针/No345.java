package 双指针;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName 双指针.ReverseVowelsOfaString
 * @Description #345 反转字符串中的元音字母
 * @Author MatthewHan
 * @Date 2020/5/9 10:02
 * @Version 1.0
 **/
public class No345 {

    public String reverseVowels(String s) {
        Set<Character> vis = new HashSet<Character>() {
            {
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
                add('A');
                add('E');
                add('I');
                add('O');
                add('U');
            }
        };

        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < arr.length && !vis.contains(arr[left])) {
                left++;
            }
            while (right >= 0 && !vis.contains(arr[right])) {
                right--;
            }
            if (left < arr.length && right >= 0 && left < right) {
                arr[left] ^= arr[right];
                arr[right] ^= arr[left];
                arr[left] ^= arr[right];
            }
            left++;
            right--;

        }
        return new String(arr);

    }

}
