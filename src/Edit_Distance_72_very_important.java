public class Edit_Distance_72_very_important {
    public int minDistance(String word1, String word2) {
        //https://www.cnblogs.com/springfor/p/3896167.html?utm_source=tuicool
        //dp
        //Time complexity: O(length1 * length2);
        //Space complexity: O(length1 * length2);
        //word1 = "horse", word2 = "ros"
        //dp[i][j]  == > word1[0..i] ==> word2[0...j];
        // dp     0 1 2 3
        //        1 1 2 3
        //        2 2 1 2
        //        3 2 2 2
        //        4 3 3 2
        //        5 4 4 3

        //  corner case
        //  dp[0][0..j] = 0...j
        //  dp[0...i][0] = 0..i

        //  if  word1.charAt(i) != word2.charAt(j)
        //                          replace        add word2[j]  delete word1[i]
        //  dp[i][j] = Math.min(dp[i - 1][j - 1] , dp[i][j - 1], dp[i - 1][j]) + 1;
        //  else
        //  dp[i][j] = dp[i - 1][j - 1];    //needn't execusive any step

        int length1 = word1.length();
        int length2 = word2.length();
        int dp[][] = new int[length1 + 1][length2 + 1];
        //corner case
        for(int i = 0; i <= length1; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= length2; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                int min = Math.min(dp[i - 1][j - 1], dp[i][j - 1]);
                min = Math.min(min, dp[i - 1][j]);
                if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                    dp[i][j] = min + 1;
                }
                else{
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[length1][length2];
    }
}
