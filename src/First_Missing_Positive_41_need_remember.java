import java.util.HashSet;

public class First_Missing_Positive_41_need_remember {
    //use HashSet
    //time complexity: O(n)
    //space complexity: O(n)
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 1;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(num <= 0){
                continue;
            }
            else{
                set.add(num);       //put positive number into set
            }
        }
        int size = set.size();
        for(int i = 1; i <= size; i++){
            if(!set.contains(i)){               //check which positive number is missing
                return i;
            }
        }
        return size + 1;
    }

    //modify array in-place
    //time complexity: O(n)
    //Space complexity: O(1)
    public int firstMissingPositive_2(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 1;
        }
        if(length == 1 && nums[0] == 1){
            return 2;
        }
        for(int i = 0; i < length;i++){
            int temp = nums[i];
            if(temp <= 0){
                continue;
            }
            //push every number to its corresponding index in the array
            while(temp < length && temp != i){
                swap(nums, i, temp);            //swap nums[i] and nums[temp] becasue nums[i] = temp
                temp = nums[i];
                if(temp < 0 || temp >= length){     //out of range
                    break;
                }
                if(temp == nums[temp]){         //repeated element
                    break;
                }
            }
        }
        //check
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        //check nums[0] becasue we don't care which element in nums[0] before
        //corner case
        if(nums[0] != length){
            return length;
        }
        else{
            return length + 1;
        }
    }
    public void swap(int[] nums, int i, int j){
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }

}
