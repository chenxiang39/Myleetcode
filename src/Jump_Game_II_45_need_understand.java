public class Jump_Game_II_45_need_understand {
    //dp
    //Time complexity: O(nums.length * nums.length)
    //Space complexity: O(nums.length)
    public int jump(int[] nums) {
        int length = nums.length;
        //corner case
        if(length == 0 || length == 1){
            return 0;
        }
        int[] dp = new int[nums.length];        //dp[i] means nums[i] minimum number of jumps to arrive the last index
        dp[length - 1] = 0;             //itself ==> 0 jump
        int target = length - 1;
        int min;
        for(int i = length - 2; i >= 0; i--){
            min = dp[i + 1];
            for(int j = 1; j <= Math.min(nums[i],length - 1 - i); j++){
                if(dp[i + j] < min){
                    min = dp[i + j];
                }
            }
            //The closest point of the last index that nums[i] can reach, just + 1 because nums[i] jump to that points need 1 step
            dp[i] = min + 1;
        }
        return dp[0];
    }

    //https://www.bilibili.com/video/BV1W4411V7Lz
    //greedy
    //Time complexity: O(nums.length)
    //Space complexity: O(1)
    public int jump_2(int[] nums) {
        int length = nums.length;
        if(length == 0 || length == 1){
            return 0;
        }
        int curend = 0;
        int furthest = 0;
        int step = 0;
        //must reachable means final furthest must >= length - 1
        for(int i = 0; i < length - 1; i++){
            //The maximum distance within the current reachable range
            if(nums[i] + i > furthest){
                furthest = nums[i] + i;
            }
            //must jump
            if(curend == i){
                step++;
                curend = furthest;
            }
        }
        return step;
    }
}
