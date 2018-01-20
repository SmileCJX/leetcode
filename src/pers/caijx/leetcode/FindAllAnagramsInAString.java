package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 * Created by Administrator on 2018/1/20/020.
 */
public class FindAllAnagramsInAString {

    /**
     * 利用滑动窗口Sliding Window的方法也比较巧妙，首先统计字符串p的字符个数，然后用两个变量left和right表示滑动窗口的左右边界，
     * 用变量cnt表示字符串p中需要匹配的字符个数，然后开始循环，如果右边界的字符已经在哈希表中了，说明该字符在p中有出现，则cnt自减1，
     * 然后哈希表中该字符个数自减1，右边界自加1，如果此时cnt减为0了，说明p中的字符都匹配上了，那么将此时左边界加入结果res中。
     * 如果此时right和left的差为p的长度，说明此时应该去掉最左边的一个字符，我们看如果该字符在哈希表中的个数大于等于0，
     * 说明该字符是p中的字符，为啥呢，因为上面我们有让每个字符自减1，如果不是p中的字符，那么在哈希表中个数应该为0，自减1后就为-1，
     * 所以这样就知道该字符是否属于p，如果我们去掉了属于p的一个字符，cnt自增1
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        for (char c : p.toCharArray()) {
            chars[c - 'a']++;
        }
        int start = 0;
        int end = 0;
        int count = p.length();
        while (end < s.length()) {
            // If the char at start appeared in p, we increase count
            if (end - start == p.length()
                    && chars[s.charAt(start++) - 'a']++ >= 0) {
                count++;
            }
            // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
            if (--chars[s.charAt(end++) - 'a'] >= 0) {
                count--;
            }
            if (count == 0) {
                result.add(start);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = findAnagrams("cbaebabacd","abc");
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
