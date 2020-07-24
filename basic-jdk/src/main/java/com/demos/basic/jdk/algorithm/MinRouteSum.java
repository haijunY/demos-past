package com.demos.basic.jdk.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yinhaijun
 * @date: 2020/7/23
 */
public class MinRouteSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                                    {1,3,1,1},
                                    {1,5,2,2},
                                    {4,2,1,2}
                                    };
        System.out.println(new MinRouteSum().minPathSum(grid));
    }

//    public int minPathSum(int[][] grid) {
//        int m = grid.length;//高
//        int n = grid[0].length;//宽
//        //向右移动n-1步，向下移动m-1步
//        int L = 0;//最大为n-1
//        int D = 0;//最大为m-1
//        //当前的数字为grid[D][L],当前数字的右下角对角数字为grid[D+1][L+1]
//        int minSum = 0;
//        int nowSum = 0;
//        // 定义以L为基准的轨迹的LRoute,D为基准的轨迹DRoute
//        String key = "";
//        Map<String, Integer> map = new HashMap<String, Integer>();//key为轨迹标记，value为当前和
//        while (L <= n-1 || D<= m -1){
//            Map<String, Integer> now = getVarMap(grid[D][L], D, L);
//        }
//
//
//        return n;
//    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }

}
