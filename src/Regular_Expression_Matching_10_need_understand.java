public class Regular_Expression_Matching_10_need_understand {
    //https://zhuanlan.zhihu.com/p/40294596
    //dp
    //Time complexity: O(s.length * p.length)
    //Space complexity: O(s.length * p.length)
    private boolean isEqual(String s, String p, int i, int j){
        return s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.';
    }
    public boolean isMatch(String s, String p) {
        //dp[i][j]  ==> whether s[0, i] match p[0, j];
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        //corner cases
        //if p == null && s != null
        for(int i=1; i<= s.length(); i++)
            dp[i][0] = false;
        //if s == null , p contain "*", can ignore previous element
        for(int j=1; j<=p.length(); j++){
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                //if not "*", check equal condition
                if(p.charAt(j - 1) != '*'){
                    dp[i][j] = dp[i - 1][j - 1] && isEqual(s,p,i,j);
                }
                //appear '*'
                else{
                    //   a    b     <=>    a   *    a    b
                    //   a    b     <=>    c   *    a    b
                    //  i-2  i-1          j-2 j-1


                    //这种情况说明上一个字符即不是.，也不和输入串的当前字符一样，所有无法用一个或多个上一个字符对输入串进行匹配，
                    //此时*只能匹配0个上一个字符:dp[i][j] = dp[i][j-2];
                    if(p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.'){
                        dp[i][j] = dp[i][j - 2];        // must!!!!!! represent zero of preceding element
                    }

                    //(1) f          <=>   f    .    *   =>  can be represent zero preceding element
                    //   i-1                   j   j + 1

                    //(2) a    a   c   b <=>    a   *    c    b   => represent one preceding element
                    //   i-2  i-1              j-2 j-1

                    //(3) a    a   a   b <=>    a   *  b   => represent more than one preceding elements
                    //   i-2  i-1              j-2 j-1
                    else{
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j]; //多代替一个字符串(因为s的后一个字符与p的前一个相同)
                    }
                }
            }
        }
        return dp[n][m];
    }
}
