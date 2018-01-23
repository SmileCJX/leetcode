package pers.caijx.leetcode;

/**
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?

 Credits:
 Special thanks to @yukuairoy for adding this problem and creating all test cases.
 * Created by Administrator on 2018/1/23/023.
 */
public class PowerOfFour {

    /**
     * 最直接的方法就是不停的除以4，看最终结果是否为1
     * @param num
     * @return
     */
    public static boolean isPowerOfFour1(int num) {
        while (num > 0 && (num % 4 == 0)) {
            num /= 4;
        }
        return num == 1;
    }

    /**
     * 使用换底公式
     * @param num
     * @return
     */
    public static boolean isPowerOfFour2(int num) {
        return (num > 0) && ((int)(Math.log10(num) / Math.log10(4)) - (Math.log10(num) / Math.log10(4)) == 0);
    }

    /**
     * 在确定其是2的次方数了之后，发现只要是4的次方数，减1之后可以被3整除
     * 如果一个数是2的次方数的话，根据上面分析，那么它的二进数必然是最高位为1，其它都为0，
     * 那么如果此时我们减1的话，则最高位会降一位，
     * 其余为0的位现在都为变为1，那么我们把两数相与，就会得到0
     * @param num
     * @return
     */
    public static boolean isPowerOfFour3(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num -1) % 3 == 0;
    }

    /**
     * 二进制表示下，只有最高位是1，那么由于是2的次方数，不一定是4的次方数，比如8，
     * 所以我们还要其他的限定条件，我们仔细观察可以发现，4的次方数的最高位的1都是计数位，
     * 那么我们只需与上一个数(0x55555555) <==> 1010101010101010101010101010101，
     * 如果得到的数还是其本身，则可以肯定其为4的次方数：
     * @param num
     * @return
     */
    public static boolean isPowerOfFour4(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) == num;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfFour4(16));
    }
}
