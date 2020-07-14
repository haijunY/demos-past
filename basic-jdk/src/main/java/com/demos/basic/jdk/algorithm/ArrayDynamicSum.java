package com.demos.basic.jdk.algorithm;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yinhaijun
 * @date: 2020/7/14
 */
public class ArrayDynamicSum {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4};
        int[] res = new ArrayDynamicSum().runningSum(nums);
        for(int i=0; i<res.length ;i++){
            System.out.println(res[i]);
        }
    }

    /**
     * 不改变传入的数组
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0;
        for(int i=0; i<nums.length ;i++){
            sum = sum + nums[i];
            res[i] = sum;
        }
        return res;
    }

    /**
     * 改变传入的数组
     * @param nums
     * @return
     */
    public int[] runningSum1(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }

}
