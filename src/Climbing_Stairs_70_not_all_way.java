public class Climbing_Stairs_70_not_all_way {
    //https://www.youtube.com/watch?v=UyDyc6yV1iQ&feature=youtu.be
    //爬楼梯的问题，思路和Unique Paths问题类似。我们假设到了第i个台阶，因为每次只能走一步和两步，因此到第i个台阶的方式等于到第i-1个台阶的方式和到第i-2个台阶的方式的和，
    //这时i > 1; 递推式为dp[i] = dp[i - 1] + dp[i - 2]
    //时间复杂度：O(n), Single loop upto n
    //空间复杂度：O(n), the size of dp array;
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];      //递推式
        }
        return dp[n - 1];
    }
    public static void main(String[] args){
        System.out.println(climbStairs(3));
    }
}
