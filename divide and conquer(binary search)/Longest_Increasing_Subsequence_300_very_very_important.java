import java.util.ArrayList;

public class Longest_Increasing_Subsequence_300_very_very_important {
    //https://blog.csdn.net/xushiyu1996818/article/details/86488853
    //brute force (dp)
    //dp[i] means from[0...i], the longest Increasing Subsequence
    //Time complexity: O(n^2), n is the length of nums;
    //Space complexity: O(n), dp array;
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for(int i = 1; i < nums.length; i++){
            int dpMax = 0;
            //calculate the max dp[j] that (nums[i] > nums[j])
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    dpMax = Math.max(dp[j], dpMax);
                }
            }
            //update dp[i] = dpMax + 1;
            dp[i] = dpMax + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }
    //Binary Search + Optional collection
    //Time complexity: O(n * logn), n is the length of nums;
    //Space complexity: O(n), ArrayList;
    public int lengthOfLIS_2(int[] nums) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(array.isEmpty()){
                array.add(nums[i]);
            }
            else{
                if(array.get(array.size() - 1) < nums[i]){
                    array.add(nums[i]);
                }
                //Binary Search
                else{
                    int lo = 0;
                    int hi = array.size() - 1;
                    int mid = lo + (hi - lo) / 2;
                    while(lo <= hi){
                        mid = lo + (hi - lo) / 2;
                        if(array.get(mid) == nums[i]){
                            break;
                        }
                        if(array.get(mid) > nums[i]){
                            hi = mid - 1;
                        }
                        else{
                            lo = mid + 1;
                        }
                    }
                    //替换掉大于他的元素中最小的那个
                    if(array.get(mid) < nums[i]){
                        array.set(mid + 1,nums[i]);
                    }
                    else{
                        array.set(mid,nums[i]);
                    }
                }
            }
        }
        return array.size();
    }
}
