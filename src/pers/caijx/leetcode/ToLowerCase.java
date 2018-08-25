package pers.caijx.leetcode;

/**
 Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 Example 1:

 Input: "Hello"
 Output: "hello"
 Example 2:

 Input: "here"
 Output: "here"
 Example 3:

 Input: "LOVELY"
 Output: "lovely"

 * Created by caijx on 2018/8/25/025.
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int temp = str.charAt(i);
            if (temp <= 90 && temp >= 65) {
                sb.append((char)(temp + 32));
            } else {
                sb.append((char)temp);
            }
        }
        return sb.toString();
    }
}
