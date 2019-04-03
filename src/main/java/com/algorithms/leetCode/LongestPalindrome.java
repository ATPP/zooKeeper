package com.algorithms.leetCode;

/**
 * 回文
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        longestPalindrome.solution("babad");
    }

    int maxlenth, lo;

    public String solution(String s) {

        if (s.length() < 2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            //中心扩展
            //如果是奇数长度
            expandFromCenter(s, i, i);
            //如果是偶数
            expandFromCenter(s, i, i + 1);
        }
        System.out.println(s.substring(lo, lo + maxlenth));
        return s.substring(lo, lo + maxlenth);
    }

    private void expandFromCenter(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxlenth < k - j - 1) {
            //开始位置
            lo = j + 1;
            //回文最大长度
            maxlenth = k - j - 1;
        }
    }
}
