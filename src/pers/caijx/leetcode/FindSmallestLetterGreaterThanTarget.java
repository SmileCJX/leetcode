package pers.caijx.leetcode;

/**
 Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 find the smallest element in the list that is larger than the given target.

 Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

 Examples:
 Input:
 letters = ["c", "f", "j"]
 target = "a"
 Output: "c"

 Input:
 letters = ["c", "f", "j"]
 target = "c"
 Output: "f"

 Input:
 letters = ["c", "f", "j"]
 target = "d"
 Output: "f"

 Input:
 letters = ["c", "f", "j"]
 target = "g"
 Output: "j"

 Input:
 letters = ["c", "f", "j"]
 target = "j"
 Output: "c"

 Input:
 letters = ["c", "f", "j"]
 target = "k"
 Output: "c"
 Note:
 letters has a length in range [2, 10000].
 letters consists of lowercase letters, and contains at least 2 unique letters.
 target is a lowercase letter.
 * Created by caijx on 2018/9/4/004.
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if (target >= letters[n -1]) {
            target = letters[0];
        } else {
            target++;
        }
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] == target) {
                return letters[mid];
            }
            if (letters[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return letters[hi];
    }
}
