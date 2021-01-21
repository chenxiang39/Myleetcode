import java.util.Arrays;

public class Matchsticks_to_Square_473_need_review {
    //dfs
    //先算出正方形的边长（和除以4),再根据边长进行匹配，如果中间出现无法匹配边长的边长就返回false
    public boolean makesquare(int[] nums) {
        //corner case
        if(nums.length < 4){
            return false;
        }
        int sum = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        //corner case
        if(sum % 4 != 0){
            return false;
        }
        int side = sum / 4;
        boolean[] isVis = new boolean[nums.length]; //是否被用过
        //每个没访问过的点都进行尝试
        for(int i = nums.length - 1; i >= 0; i--){
            if(isVis[i]){
                continue;
            }
            if(!dfs(nums, isVis, 0, i, side)){
                return false;
            }
        }
        //如果所有的值都用过且满足拼出正方形，返回true
        return true;
    }
    public boolean dfs(int[] nums, boolean[] isVis, int cur, int end, int side){
        cur += nums[end];       //之前算的边长加上当前的长度
        //大于固定边长就返回
        if(cur > side){
            return false;
        }
        //等于就输出并标记访问过该点
        if(cur == side){
            isVis[end] = true;
            return true;
        }
        //小于就继续dfs搜索之前的数（由小到大排序，从大的开始）
        else{
            for(int i = end - 1; i >= 0; i--){
                if(isVis[i]){
                    continue;
                }
                //如果之后的可以拼凑，说明该数可以被拼成某一个边长，因此为true,并设置已访问
                if(dfs(nums, isVis, cur, i, side)){
                    isVis[end] = true;
                    return true;
                }
            }
            //全部试过都不能拼凑，返回false
            return false;
        }
    }
}
