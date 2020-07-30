package 面试题;

/**
 * @ClassName SparseArraySearch
 * @Description 面试题 10.05. 稀疏数组搜索
 * @Author MatthewHan
 * @Date 2020/7/29 09:02
 * @Version 1.0
 **/
public class SparseArraySearch {

    public static int findString(String[] words, String s) {
        return binarySearch(words, s);
    }

    public static int binarySearch(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int temp = mid;
            while (mid >= 0 && !s.equals(words[mid])) {
                mid--;
            }
            // mid = -1 说明左边没找到非空字符串
            while (mid == -1 && temp < words.length && !s.equals(words[temp])) {
                temp++;
            }
            // 右边索引走到了末尾 + 1，说明右边也没找到，直接return -1;
            if (temp == words.length && mid == -1) {
                return -1;
            }

            mid = mid == -1 ? temp : mid;
            char sIndex = s.charAt(0);
            char wIndex = words[mid].charAt(0);
            if (wIndex == sIndex) {
                return mid;
            } else if (wIndex < sIndex) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
