package pers.caijx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 Implement a MapSum class with insert, and sum methods.

 For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

 For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

 Example 1:
 Input: insert("apple", 3), Output: Null
 Input: sum("ap"), Output: 3
 Input: insert("app", 2), Output: Null
 Input: sum("ap"), Output: 5

 * Created by caijx on 2018/8/22/022.
 */
public class MapSumPairs {

    /** Initialize your data structure here. */
    Map<String,Integer> mem;
    Map<String,Integer> set;

    public MapSumPairs() {
        mem = new HashMap<>();
        set = new HashMap<>();
    }

    public void insert(String key, int val) {
        if (!set.containsKey(key)) {
            set.put(key,val);
            for (int i = 0; i <= key.length(); ++i) {
                String sub = key.substring(0,i);
                mem.put(sub,mem.getOrDefault(sub,0) + val);
            }
        } else {
            int cnt = set.get(key);
            for (int i = 0; i <= key.length(); ++i) {
                String sub = key.substring(0,i);
                mem.put(sub,mem.get(sub) - cnt + val);
            }
        }
    }

    public int sum(String prefix) {
        if (!mem.containsKey(prefix)) {
            return 0;
        }
        return mem.get(prefix);
    }

}
