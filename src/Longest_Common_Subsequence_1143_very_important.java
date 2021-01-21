public class Longest_Common_Subsequence_1143_very_important {
    //dp
    //n: the length of text1
    //m: the length of text2
    //Time complexity: O(n*m)
    //Space complexity: O(n*m),dp array
    //dp[i][j] means the longest common subsequence between text1<t1..ti> 	and text2<t1..tj>
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int dp[][] = new int[l1 + 1][l2 + 1];
        //The initial condition
        for(int i = 0; i <= l1; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i <= l2; i++){
            dp[0][i] = 0;
        }
        //Dp[i][j] = dp[i – 1][j – 1] + 1, if xi == zj, 第i个和第j个匹配
        //Dp[i][j] = Max(dp[i][j – 1], dp[i – 1][j]), if xi != zj, 不相等，因此选择之前大的字串长度
        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                if(text1.charAt(i - 1) != text2.charAt(j - 1)){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                else{
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}
