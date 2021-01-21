import java.util.HashMap;

public class Single_Number_Two_137_not_all_way {
    //HashMap
    //Time complexity : O(n), n : length of nums
    //Space complexity: O(n), HashMap
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();  //Key: 表示元素, Value: 表示出现的次数
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == 1){
                return nums[i];
            }
        }
        return -1;
    }
}
