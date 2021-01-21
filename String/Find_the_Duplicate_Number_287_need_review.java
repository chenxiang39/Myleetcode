import java.util.HashSet;
import java.util.Set;

public class Find_the_Duplicate_Number_287_need_review {
    //使用hashset,直接去重，还有其他方法（佛洛依德环）
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return num;
            }
            else{
                set.add(num);
            }
        }
        return 0;
    }
}
