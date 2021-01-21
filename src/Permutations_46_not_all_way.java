import java.util.ArrayList;
import java.util.List;

public class Permutations_46_not_all_way {
    //dfs
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs (result, nums, cur);
        return result;
    }
    private static void dfs(List<List<Integer>> result, int[] nums, List<Integer> cur){
        if (cur.size() == nums.length){
            result.add(new ArrayList<>(cur));           //此处写法请看40题
            return;
        }
        for (int i = 0; i < nums.length; i++){
            int choosedInt = nums[i];
            if (cur.contains(choosedInt)){      //已经包含了就跳过循环
                continue;
            }
            cur.add(choosedInt);
            dfs(result, nums, cur);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
