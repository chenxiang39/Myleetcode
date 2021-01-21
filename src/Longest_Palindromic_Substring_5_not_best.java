public class Longest_Palindromic_Substring_5_not_best {
    public static String longestPalindrome(String s) {
        //动态规划法
        //如果 s[start+1, end-1] 是回文串，那么只要 s[start] == s[end]，就可以确定 s[start, end] 也是回文串了。
        if (s == null || "".equals(s)){
            return s;
        }
        int n = s.length();
        String answ = "";
        int maxlength = 0;
        boolean [][] dp = new boolean[n][n];
        for (int end = 0; end < n; end++ ){
            for (int start = 0; start <= end; start++){
                boolean judge = s.charAt(start) == s.charAt(end); //如果start和end一样，则标记
                dp[start][end] = end - start > 2? judge && dp[start + 1][end - 1]: judge; //如果一共只有start和end两个字符，则只看judge的结果，否则看中间部分[start+1, end-1] 是否为回文，若是，则看judge的结果
                if (dp[start][end] && end - start + 1 > maxlength){     //dp[start][end]为true（证明start到end为回文），且比之前存放的最大长度长，则更新
                    maxlength = end - start + 1;
                    answ = s.substring(start, end + 1);
                }
            }
        }
        return answ;
    }
    public static void main(String[] args){
        System.out.println(longestPalindrome("eg"));
    }
}
