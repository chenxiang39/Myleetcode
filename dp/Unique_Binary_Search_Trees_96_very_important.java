public class Unique_Binary_Search_Trees_96_very_important {
    //https://www.cnblogs.com/springfor/p/3884009.html
    //时间上每次求解i个结点的二叉查找树数量的需要一个i步的循环，总体要求n次，所以总时间复杂度是O(1+2+...+n)=O(n^2)。
    // 空间上需要一个数组来维护，并且需要前i个的所有信息，所以是O(n)。
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j ++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
