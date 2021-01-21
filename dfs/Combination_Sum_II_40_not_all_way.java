import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II_40_not_all_way {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new  ArrayList<>();
        Arrays.sort(candidates);
        dfs (result, candidates, target,list,0);
        return result;
    }
    private static void dfs(List<List<Integer>> result, int[] candidates, int target, List<Integer> list, int start){
        if (target == 0){                           //如果taregt变为0,则list中的值符合条件
            result.add(new ArrayList<>(list));      //重要，必须有new，因为后面remove的操作会改变list的值,没new,只是一个引用,开辟了新空间(运算空间复杂度需要注意)
            return;
        }
        for (int i = start ; i < candidates.length; i++){
            if (candidates[start] > target){
                break;
            }
            //与之前计算过的重复大小的元素则略过不操作，i大于start的意思是，遍历到之后发现重复的就不算，如果是开头的，则说明该元素为新元素（即使重复也没关系）
            if (i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            list.add(candidates[i]);
            dfs(result, candidates, target - candidates[i],list,i + 1);
            list.remove(list.size() - 1);             //删除最后一位，回溯
        }
    }
    public static void main(String[] args){
        int[] nums = {0,1,1,1,2};
        System.out.println(combinationSum2(nums,2));
    }
}
