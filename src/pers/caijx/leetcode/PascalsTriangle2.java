package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 * Created by Administrator on 2018/1/13/013.
 */
public class PascalsTriangle2 {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >=1; j--) {
                int tmp = ret.get(j) + ret.get(j - 1);
                ret.set(j,tmp);
            }
            ret.add(1);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3).toString());
    }
}
