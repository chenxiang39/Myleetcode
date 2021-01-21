import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence_128_need_review {
    //time complexity: O(n), while只在存在可能的序列中才会推进，并且不会从中间开始计算序列
    //space complexity: O(n),HashSet
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int result = 0;
        for(int num : nums){
            if(!set.contains(num - 1)){     //进行优化，从可能存在的序列的最小值开始才是答案
                int cur = 1;
                int target = num + 1;
                //是否存在递增序列，进行搜索
                while(set.contains(target)){
                    cur++;
                    target++;
                }
                result = Math.max(result,cur);
            }
        }
        return result;
    }
}
