import java.util.HashMap;

public class Majority_Element_169_not_all_way {
    //HashMap
    //时间复杂度：O(n);
    //空间复杂度: O(n);
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();        //记录元素及其出现的次数
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i]) + 1);
                if(map.get(nums[i]) > nums.length / 2){
                    return nums[i];
                }
            }
        }
        return nums[0];     //防止只有1个元素的特殊情况
    }
}
