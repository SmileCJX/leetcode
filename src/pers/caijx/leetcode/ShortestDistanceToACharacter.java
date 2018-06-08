package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

 Example 1:

 Input: S = "loveleetcode", C = 'e'
 Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


 Note:

 S string length is in [1, 10000].
 C is a single character, and guaranteed to be in string S.
 All letters in S and C are lowercase.

 * Created by Administrator on 2018/6/8/008.
 */
public class ShortestDistanceToACharacter {

    public int[] shortestToChar(String S, char C) {
        List<Integer> indexs = new ArrayList<>();
        for (int x = 0; x < S.length(); x++) {
            if (C == S.charAt(x)) {
                indexs.add(x);
            }
        }
        int[] distances = new int[S.length()];
        for (int x = 0; x < S.length(); x++) {
            int secondDistance = 0;
            if (indexs.size() > 1) {
                secondDistance = Math.abs(indexs.get(1) - x);
            }
            int firstDistance = Math.abs(indexs.get(0) - x);
            if (S.charAt(x) == C) {
                distances[x] = 0;
            }
            if (indexs.size() == 1) {
                distances[x] = firstDistance;
            } else if (firstDistance < secondDistance) {
                distances[x] = firstDistance;
            } else if (secondDistance < firstDistance) {
                distances[x] = secondDistance;
                indexs.remove(0);
            } else if (secondDistance == firstDistance) {
                distances[x] = secondDistance;
                indexs.remove(0);
            }
        }
        return distances;
    }
}
