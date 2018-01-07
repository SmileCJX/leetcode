package pers.caijx.leetcode;

/**
 * Created by Administrator on 2018/1/7/007.
 */
public class Sqrtx {

    /**
     * A Binary Search Solution
     */
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (true) {
//            if the left and the right is very big,the (right+left) may exceed the INT_MAX,
//            so it’s better to use left+(right-left)/2 instead
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}
