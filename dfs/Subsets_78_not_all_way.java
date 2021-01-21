import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//dfs
//Time complexity: O(N×2的N次方) to generate all subsets and then copy them into output list.
//Space complexity: O(N×2的N次方) to keep all the subsets of length N, since each of N elements could be present or absent.
public class Subsets_78_not_all_way {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i <= nums.length;i++){      //在77题解法的基础上，加上元素长度的遍历控制
            dfs(result,nums,cur,i,0);
        }
        return result;
    }
    //类似77题的解法
    private static void dfs(List<List<Integer>> result, int[] nums, List<Integer> cur, int amount, int start){
        if(cur.size() == amount){
            result.add(new ArrayList(cur));
            return;
        }
        for(int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            dfs(result,nums,cur,amount,i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args){
        int[] nums = {6,2,3};
        System.out.println(subsets(nums));
    }
}
