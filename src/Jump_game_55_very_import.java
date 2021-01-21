//https://blog.csdn.net/u014106644/article/details/93472630

public class Jump_game_55_very_import {
    //recursive way (bad way)(two slow)
    //Time complexity : O(2^n) (upper bound) ways of jumping from the first position to the last, where nn is the length of array nums.
    //Space complexity : O(n). Recursion requires additional memory for the stack frames.
    private static boolean canJump(int[] nums){
        return checkJumpPos(nums,0);
    }
    private static boolean checkJumpPos(int[] nums, int pos) {
         if(pos == nums.length - 1){
             return true;
         }
         int tryJump = Math.min(nums.length - 1, nums[pos] + pos);
         for (int i = pos + 1; i < tryJump; i++){
             if(checkJumpPos(nums,i)){
                 return true;
             }
         }
         return false;
    }

    //DP , top -> bottom
    //Time complexity : O(n^2) For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. nums[i] can be at most nn, where nn is the length of array nums.
    //Space complexity : O(2n) = O(n). First n originates from recursion. Second n comes from the usage of the memo table.
    enum Index {            //enum,枚举类型
        GOOD, BAD, UNKNOWN
    }
        private static Index[] memo;
        public static boolean canJumpFromPosition(int position, int[] nums) {
            if (memo[position] != Index.UNKNOWN) {
                return memo[position] == Index.GOOD ? true : false;     //因为最后一个位置（即目标位置为good，所以能反推，能到达good的点就是good的）
            }

            int furthestJump = Math.min(position + nums[position], nums.length - 1);
            for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
                if (canJumpFromPosition(nextPosition, nums)) {      //跳过bad的点
                    memo[position] = Index.GOOD;            //能到达good的点设置为good
                    return true;
                }
            }

            memo[position] = Index.BAD;         //最终不能到达good的点设置为bad
            return false;
        }

        public static boolean canJump_2(int[] nums) {
            memo = new Index[nums.length];
            for (int i = 0; i < memo.length; i++) {
                memo[i] = Index.UNKNOWN;
            }
            memo[memo.length - 1] = Index.GOOD;         //最后一个位置默认good
            return canJumpFromPosition(0, nums);
        }

    //DP, Bottom -> Top
    //Time complexity : O(n^2)
    //For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. nums[i] can be at most nn, where nn is the length of array nums.
    //Space complexity : O(n). This comes from the usage of the memo table.
    public static boolean canJump_3(int[] nums) {
        Index[] dp = new Index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Index.UNKNOWN;
        }
        dp[nums.length - 1] = Index.GOOD;         //终点为good

        for (int i = nums.length - 2; i >= 0; i--) {        //反过来推算
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {           //如果 i+1比furthestJump大，则循环不执行
                if (dp[j] == Index.GOOD) {                //能到达good的点就是good
                    dp[i] = Index.GOOD;
                    break;                                  //变成good就终止
                }
            }
        }

        return dp[0] == Index.GOOD;               //是否最开始的点是good
    }
    //Greedy
    //Time complexity : O(n). We are doing a single pass through the nums array, hence nn steps, where nn is the length of array nums.
    //Space complexity : O(1) . We are not using any extra memory.
    public static boolean canJump_4(int[] nums){
        int lastPos = nums.length - 1;      //可以到达的最远位置，从后往前推
        for(int i = nums.length - 2; i >= 0; i--){
            if (nums[i] + i >= lastPos){        //前一个点是否能到达指定位置的点（经过递推可以证明，lastPos是检测点是否能到最后的点）
                lastPos = i;        //能的话更新lastPos，往前递推
            }
        }
        return lastPos == 0;        //第一个点是否是lastPos的点
    }
    public static void main(String[] args){
        int[] nums = {3,2,2,1,0,4};
        System.out.println(canJump_3(nums));
        for (int i = 5; i <=4;i++){
            System.out.println("xx");
        }
    }
}
