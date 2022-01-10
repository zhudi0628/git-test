package Leetcode;

/**
 * @author 96309
 * @create 2022 01 09 21:57
 */
public class MaxLengthOfPalindrome {


    public static void main(String[] args) {

        String a = "asnjdnabadadddad";

        String s = longestPalindrome(a);

        System.out.println("最长回文字符串是：" + s);
        System.out.println("最长回文字符串是：" + s);
    }

    public static String longestPalindrome(String s){


        if(s.length() == 1){
            return s;
        }

        String res = ""; //用于存储最长字符串

        //遍历s中的每个字符，以每个字符为对称中心
        for (int i = 0;i < s.length();i++){

            //回文数可能是 babad中 bab 属于以a为对称的奇数对称
            String str1 = FindPalindrome(s,i,i);

            //也可能是 cbbd 类型的偶数对称
            String str2 = FindPalindrome(s,i,i+1);

            res = res.length() > str1.length() ? res : str1;
            res = res.length() > str2.length() ? res : str2;

        }

        return res;
    }

    //查找回文数
    public static String FindPalindrome(String s,int left,int right){

        //在区间【0,s.length()-1】范围内查找，防止下标越界
        while(left >=0 && right < s.length()){

            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }

        }

        //string.substring(start,end):截取start到end-1的位置
        return s.substring(left+1,right);
    }


}
