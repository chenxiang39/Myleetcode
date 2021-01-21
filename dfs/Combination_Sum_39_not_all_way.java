import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//dfs
public class Combination_Sum_39_not_all_way {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, candidates ,list, 0, target);
        return result;
    }
    public static void dfs(List<List<Integer>> result, int[] candidates,List<Integer> list, int start, int target){
        if (target == 0){       //如果taregt变为0,则list中的值符合条件
            result.add(new ArrayList<>(list));      //重要，必须有new，因为后面remove的操作会改变list的值
            return;
        }
        //i从start开始可以保证不重复（因为candidates不重复）
        for (int i = start; i < candidates.length; i++){
            //下次进来的target如果比存在的最小数（已经排过序）还小，则退出循环，因不存在匹配值
            if (target < candidates[start]){
                break;
            }
            else{
                list.add(candidates[i]);
                dfs(result, candidates ,list, i, target - candidates[i]);
                list.remove(list.size() - 1);       //删除最后一位，回溯
            }
        }
    }
    public static void main(String[] args){
        int[] nums = {2,3,4};
        System.out.println(combinationSum(nums,2));
    }
}
