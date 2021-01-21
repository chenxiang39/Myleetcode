public class Interleaving_String_97_need_understand {
    //dp
    //https://blog.csdn.net/zangdaiyang1991/article/details/90209620
    //Time complexity: O(s1.length * s2.length)
    //Space complexity: O(s1.length * s2.length),dp array (s1.length + 1) * (s2.length + 1)
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        //dp[i][j]表示s3的前i+j个字符可以由s1的前i个字符和s2的前j个字符交织而成
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        for (int i = 0; i < l1 + 1; i++) {
            for (int j = 0; j < l2 + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (s2.charAt(j - 1) != s3.charAt(j - 1)) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (j == 0) {
                    if (s1.charAt(i - 1) != s3.charAt(i - 1)) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    //表示若s3的前i+j-1个字符能够由s1前i-1个字符和s2的前j个字符交织而成，那么只需要s1的第i个字符与s3的第i+j个字符相等（charAt索引从0开始），那么dp[i][j]=true
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            //表示若s3的前i+j-1个字符能够由s1前i个字符和s2的前j-1个字符交织而成，那么只需要s2的第j个字符与s3的第i+j个字符相等（charAt索引从0开始），那么dp[i][j]=true
                    (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[l1][l2];
    }
}
