package pers.caijx.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * Created by Administrator on 2017/12/21/021.
 */
public class LongestCommonPrefix {

    /**
     * Horizontal scanning
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * (Vertical scanning)
     Algorithm
     Imagine a very short string is at the end of the array.
     The above approach will still do SS comparisons. One way to optimize this case is to do vertical scanning.
     We compare characters from top to bottom on the same column (same character index of the strings) before moving on to the next column.
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 分治算法
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix3(strs,0,strs.length-1);
    }

    private static String longestCommonPrefix3(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix3(strs,l,mid);
            String lcpRight = longestCommonPrefix3(strs,mid+1,r);
            return commonPrefit(lcpLeft,lcpRight);
        }
    }

    private static String commonPrefit(String lcpLeft, String lcpRight) {
        int min = Math.min(lcpLeft.length(),lcpRight.length());
        for (int i = 0; i < min; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0,i);
            }
        }
        return lcpLeft.substring(0,min);
    }

    /**
     * 二分查找
     * @param strs
     * @return
     */
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen,str.length());
        }
        int low = 1;
        int high = minLen;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefit(strs,mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0,(low + high) / 2);
    }

    private static boolean isCommonPrefit(String[] strs, int mid) {
        String str1 = strs[0].substring(0,mid);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"leets","leetcode","leetkobeleet"};
        System.out.println(longestCommonPrefix4(strs));
    }
}
