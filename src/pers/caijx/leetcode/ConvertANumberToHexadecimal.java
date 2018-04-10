package pers.caijx.leetcode;

/**
 Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

 Note:

 All letters in hexadecimal (a-f) must be in lowercase.
 The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 The given number is guaranteed to fit within the range of a 32-bit signed integer.
 You must not use any method provided by the library which converts/formats the number to hex directly.
 Example 1:

 Input:
 26

 Output:
 "1a"
 Example 2:

 Input:
 -1

 Output:
 "ffffffff"
 * Created by Administrator on 2018/4/10/010.
 */
public class ConvertANumberToHexadecimal {

    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    /**
     each time we take a look at the last four digits of
     binary verion of the input, and maps that to a hex char
     shift the input to the right by 4 bits, do it again
     until input becomes 0.
     按位与来获取。既然是得到十六进制，那么每次与上0xF（二进制就是1111），得到一个值，然后数字向右移动4位，
     这里需要注意的是数字是有符号的，刚好可以利用Java提供的无符号移动>>>
     * @param num
     * @return
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String result = "";
        while (num != 0) {
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }
}
