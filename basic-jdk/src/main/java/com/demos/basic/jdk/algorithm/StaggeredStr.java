package com.demos.basic.jdk.algorithm;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yinhaijun
 * @date: 2020/7/18
 */
public class StaggeredStr {
    public static void main(String[] args) {
        String s1 = "aa"; String s2 = "ab"; String s3 = "aaba";
        System.out.println(new StaggeredStr().isInterleave(s1, s2, s3));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int len = s3.length();
        if(s1.length() + s2.length() !=  len){
            return false;
        }else if(s1.length() == 0 && s3.length() == 0 &&s3.length() == 0){
            return true;
        }
        int j = 1;
        for(int i = 0; i < len; i++){
            String attr = s3.substring(i, i + j);
            if(s1.startsWith(attr) && !s2.startsWith(attr) && (s1.length() > 0 || s2.length() > 0)){
                s1 = s1.substring(j);//去除开头已经被匹配过的
                i = i + j -1;
                j = 1;
                if(s1.length() == 0 && s2.length() == 0){
                    return true;
                }
            }
            else if(!s1.startsWith(attr) && s2.startsWith(attr) && (s1.length() > 0 || s2.length() > 0)){
                s2 = s2.substring(j);//去除开头已经被匹配过的
                i = i + j -1;
                j = 1;
                if(s1.length() == 0 && s2.length() == 0){
                    return true;
                }
            }else if(s1.startsWith(attr) && s2.startsWith(attr)){
                j++;
                i--;
            }else {
                return false;
            }
        }
        return false;
    }

}
