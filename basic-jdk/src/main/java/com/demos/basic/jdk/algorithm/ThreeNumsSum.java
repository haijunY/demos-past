package com.demos.basic.jdk.algorithm;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yinhaijun
 * @date: 2020/7/17
 */
public class ThreeNumsSum {

    public static void main(String[] args) {
        int[] nums = new int []{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int []{0,3,0,1,1,-1,-5,-5,3,-3,-3,0};
        List<List<Integer>> res = new ThreeNumsSum().threeSum1(nums);
        for(List<Integer> re : res){
            for(Integer r : re){
                System.out.print(r);
            }
            System.out.println();
        }
    }

    /** 双指针法 */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i <len; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    res.add(list);
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    //等于0时，证明L和R的数字都被用过了，则均向中间移动
                    L++;
                    R--;
                }
                else if(sum < 0) L++; //小于0，证明L+R的值还不够，由于排序过，左边必定小于右边，则应该将L增大
                else if(sum > 0) R--;
            }
        }
        return res;
    }


    /** 排距法 */
    public List<List<Integer>> threeSum1(int[] nums) {
        //相加为0分为4种情况，三个0、一个0一正一负、两正一负、两负一正
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        List<Integer> list0 = new ArrayList<>();
        Map<Integer, Integer> mapZ = new HashMap<>();
        Map<Integer, Integer> mapF = new HashMap<>();
        for(int i = 0; i < len; i++) {
            if(nums[i] == 0){
                list0.add(nums[i]);
            }else if (nums[i] > 0){
                mapZ.put(i, nums[i]);
            }else{
                mapF.put(i, nums[i]);
            }
        }
        int list0Size = list0.size();
        // 三个0
        if(list0Size >= 3){
            List<Integer> list0Res = new ArrayList<>();
            list0Res.add(0);list0Res.add(0);list0Res.add(0);
            res.add(list0Res);
        }else if(list0Size == 0){//一个0都没有的情况
        }else {//一个或者两个0

        }
        // 一个0一正一负
        if(list0Size > 0){
            mapZ.forEach((z,v)->{
                if(mapF.get(-z) != null){
                    List<Integer> list0Res = new ArrayList<>();
                    list0Res.add(0);list0Res.add(z);list0Res.add(-z);
                    res.add(list0Res);
                }
            });
        }
        // 两正一负、两负一正
        mapZ.forEach((z,v)->{
            mapZ.forEach((z1,v1)->{
                if(z != z1){
                    if(mapF.get( -z - z1) != null){
                        List<Integer> list0Res = new ArrayList<>();
                        list0Res.add(z);list0Res.add(z1);list0Res.add(-z - z1);
                        res.add(list0Res);
                    }
                }
            });
        });
        mapF.forEach((z,v)->{
            mapF.forEach((z1,v1)->{
                if(z != z1){
                    if(mapZ.get( -z - z1) != null){
                        List<Integer> list0Res = new ArrayList<>();
                        list0Res.add(z);list0Res.add(z1);list0Res.add(-z - z1);
                        res.add(list0Res);
                    }
                }
            });
        });
        return res;
    }

}
