package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.
 Each digit must be rotated - we cannot choose to leave it alone.

 A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves;
 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

 Now given a positive number N, how many numbers X from 1 to N are good?

 Example:
 Input: 10
 Output: 4
 Explanation:
 There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 Note:

 N  will be in range [1, 10000].
 * Created by Administrator on 2018/5/16/016.
 */
public class RotatedDigits {

    List<Integer> valid = new ArrayList<>();
    List<Integer> invalid = new ArrayList<>();

    public int rotatedDigits(int N) {
        int counter = 0;
        valid.addAll(Arrays.asList(2,5,6,9));
        invalid.addAll(Arrays.asList(3,4,7));
        for (int i = 0; i <= N; i++) {
            if (isValid(i)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isValid(int i) {
        boolean cond = false;
        while (i > 0) {
            int temp = i % 10;
            if (invalid.contains(temp)) {
                return false;
            }
            if (valid.contains(temp)) {
                cond = true;
            }
            i = i / 10;
        }
        return cond;
    }
}
