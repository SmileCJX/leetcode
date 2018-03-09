package pers.caijx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 * Created by Administrator on 2018/3/9/009.
 */
public class MajorityElement {

    /**
     * Brute Force
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count++;
                }
            }

            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }

    /**
     HashMap [Accepted]
     Intuition

     We know that the majority element occurs more than \lfloor \frac{n}{2} \rfloor⌊
     ​2
     ​
     ​n
     ​​ ⌋ times, and a HashMap allows us to count element occurrences efficiently.

     Algorithm

     We can use a HashMap that maps elements to counts in order to count occurrences in linear time by looping over nums.
     Then, we simply return the key with maximum value.
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Map<Integer,Integer> counts = countNums(nums);
        Map.Entry<Integer,Integer> majorityEntry = null;
        for (Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    private Map<Integer,Integer> countNums(int[] nums) {
        Map<Integer,Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num,1);
            } else {
                counts.put(num,counts.get(num) + 1);
            }
        }
        return counts;
    }
}
