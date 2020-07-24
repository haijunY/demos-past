package com.demos.basic.jdk.algorithm;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * @author yinhaijun
 * @date: 2020/7/22
 */
public class SpinArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        new SpinArray().rotate1(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(len == 0){
            return;
        }
        k = k%len;
        int[] numsC = Arrays.copyOf(nums, len);
        for(int i = 0; i < len; i++){
            if(i+k>len-1){
                nums[(i+k)%len] = numsC[i];
            }else {
                nums[i+k] = numsC[i];
            }
        }
    }

    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        if(len == 0){
            return;
        }
        k = k%len;
        int[] numsLeft = new int[len-k];
        int[] numsRight = new int[k];
        int r = 0;
        int l = 0;
        for(int i = 0; i < len; i++){
            if(i<k){
                numsRight[r] = nums[len-i-1];
                r++;
            }else {
                numsLeft[l] = nums[len-i-1];
                l++;
            }
        }
        System.out.println(Arrays.toString(numsLeft));
        System.out.println(Arrays.toString(numsRight));
    }

}
