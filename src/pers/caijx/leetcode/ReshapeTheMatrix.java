package pers.caijx.leetcode;

/**
 In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

 You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

 The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

 If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

 Example 1:
 Input:
 nums =
 [[1,2],
 [3,4]]
 r = 1, c = 4
 Output:
 [[1,2,3,4]]
 Explanation:
 The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 Example 2:
 Input:
 nums =
 [[1,2],
 [3,4]]
 r = 2, c = 4
 Output:
 [[1,2],
 [3,4]]
 Explanation:
 There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * Created by Administrator on 2018/3/20/020.
 */
public class ReshapeTheMatrix {

    /**
     （1）origin_r * origin_c 的矩阵 reshape为 r*c的矩阵，需要满足：
     origin_r * origin_c=r*c
     （2）元素位置对应的关系
     如果将矩阵横向展开为一维数组，元素个数为n=origin_r * origin_c
     在元素在一维数组中对应的位置i：
     原矩阵位置[i/origin_c,i%origin_c]
     新矩阵位置[i/c,i%c]
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;
        if (r * c != n * m) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / m][i % m];
        }
        return res;
    }
}
