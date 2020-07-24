package com.demos.basic.jdk.algorithm;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @author yinhaijun
 * @date: 2020/7/21
 */
public class BuySell {

    public static void main(String[] args) {
        int[] prices = new int[]{4,0,1,0,0,0,6,1,4};
        System.out.println(new BuySell().maxProfit1(prices));
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1){
            return 0;
        }
//        Integer minBuy = null;
//        Integer maxSell = null;
        Integer maxPofit = null;
        for(int i = 0; i < len; i++){
            int buy = prices[i];//固定住买点
//            if(null != minBuy && buy >= minBuy){
//                continue;
//            }
            int r = 1;
            while (r <= len - i - 1) {
                int sell = prices[i+r];
                r++;
//                if(null != maxPofit && sell <= maxPofit){
//                    continue;
//                }
                int profit = sell - buy;
                if(profit <= 0){//利润小于等于0，说明在此处（i）买入无利可图，选择跳出while循环，尝试增大i值
                    continue;
                }
                if(null == maxPofit || profit > maxPofit){
//                    minBuy = buy;
//                    maxSell = maxSell;
                    maxPofit = profit;
                }
            }
        }
        if(null == maxPofit){
            maxPofit = 0;
        }
        return maxPofit;
    }

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if(len <= 1){
            return 0;
        }
        Integer midMinBuy = null;//中间最小值
        Integer buy = null;//当前买值
        Integer sell = null;//当前卖值
        Integer maxProfit = 0;//最大利润
        for(int i = 0; i < len - 1; i++) {
            int now = prices[i];
            Integer midProfit = now - midMinBuy;
            if(midProfit > maxProfit){
                buy = midMinBuy;
                sell = now;
            }

            if(i == 0){
                buy = now;
            }
            if(now > sell){
                sell = now;
            }else if(now < buy){
                midMinBuy = now;
            }
        }
        return maxProfit;
    }


}
