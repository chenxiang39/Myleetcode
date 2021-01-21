import java.util.Arrays;

public class Missing_Number_268_need_review {
    //先排序再查看是否有缺失
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i != nums[i]){
                return i;
            }
        }
        //之前都没缺失，说明缺失了最后一个数
        return nums.length;
    }
}
