public class Wildcard_Matching_44_very_important {
    //https://www.cnblogs.com/grandyang/p/4401196.html
    //dp
    //Time complexity: O(s.length * p.length)
    //Space complexity: O(s.length * p.length)
    public boolean isMatch(String s, String p) {
        //dp[i][j] means s[0..i] whether match p[0..j];

        //corner case
        //dp[0][0] = true;
        //dp[1....s.length - 1][0] == false ==> p is null
        //if s == null , p contain "*", can represent empty element
        //if p[j - 1] == "*" ==> dp[0][i](true) == dp[0][i - 1](true);


        //if p[j - 1] == '?' || s[i] == p[i] ===> dp[i][j] = dp[i - 1][j - 1]

        //if p[j - 1] == '*'

        //(1) can ignore itself
        //dp[i][j] = dp[i][j - 1]

        //(2) can represent any seqence
        //dp[i][j] = dp[i - 1][j]

        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i++){
            dp[n][0] = false;
        }
        for(int i = 1; i <= m; i++){
            if(p.charAt(i - 1) == '*' && dp[0][i - 1]){
                dp[0][i] = true;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(p.charAt(j - 1) != '*'){
                    dp[i][j] = dp[i - 1][j - 1] && isMatch(s,p,i,j);
                }
                else{
                    //若p中第j个字符是星号，由于星号可以匹配空串，所以如果p中的前 j-1 个字符跟s中前i个字符匹配成功了（ dp[i][j-1] 为true）的话，则 dp[i][j] 也能为 true。
                    //或者若p中的前j个字符跟s中的前i-1个字符匹配成功了（ dp[i-1][j] 为true ）的话，则 dp[i][j] 也能为 true（因为星号可以匹配任意字符串，再多加一个任意字符也没问题
                    // can represent any seqence or ignore itself
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }

    public boolean isMatch(String s, String p, int i, int j){
        return s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?';
    }
}
