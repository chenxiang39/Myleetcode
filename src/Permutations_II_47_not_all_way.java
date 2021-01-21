import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II_47_not_all_way {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        for(boolean i : isVisited){
            i = false;
        }
        Arrays.sort(nums);
        dfs(result,nums,cur,isVisited);
        return result;
    }
    private static void dfs(List<List<Integer>> result, int[] nums, List<Integer> cur, boolean[] isVisited){
        if (cur.size() == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++){          //每次遍历都是从0开始
            if (isVisited[i]){              //不添加已经被访问的数字
                continue;
            }
            if (i > 0 && !isVisited[i - 1] &&nums[i] == nums[i - 1]){           //当之前的元素没有被访问（即等待被访问）时，如果此时元素与之前的大小相同（排过序），则跳过（会引起重复，因为之前的元素大小相同，得出的结果一定与此时元素的相同）
                continue;
            }
            cur.add(nums[i]);
            isVisited[i] = true;            //标注已经被访问
            dfs(result, nums, cur, isVisited);
            cur.remove(cur.size() - 1);
            isVisited[i] = false;           //还原成未被访问的状态
        }
    }
    public static void main(String[] args){
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
}
