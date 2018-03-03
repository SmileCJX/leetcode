package pers.caijx.leetcode;

/**
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?
 * Created by Administrator on 2018/3/3/003.
 */
public class AddDigits {

    /**
     Explain, take 438 as an example

     [Step 1]:

     438  == 40*10 +3*10 +8 ;

     4+3+8 == 4*(10%9)*(10%9)+3*(10%9)+8%9= 15   ;
     [Step 2]:

     15  == 1*10 + 5 ;

     1+5 == 1*(10%9)+5%9= 6 ;
     [So we can see]:

     ab%9%9%9==ab%9;

     just return num%9; and don't forget num==0 or num==9
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
    }

    public static void main(String[] args) {

    }
}
