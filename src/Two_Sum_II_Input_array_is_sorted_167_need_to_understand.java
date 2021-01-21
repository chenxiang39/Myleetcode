import java.util.HashMap;

public class Two_Sum_II_Input_array_is_sorted_167_need_to_understand {
    //类似第一题(HashMap)
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < numbers.length;i++){
            int t = target - numbers[i];
            if(map.containsKey(t)){
                result[0] = map.get(t);
                result[1] = i + 1;
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }
    //two pointer
    //时间复杂度：O(n)
    //空间复杂度：O(1)
    public int[] twoSum_2(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        while(start < end){
            int sum = numbers[start] + numbers[end];        //求和
            if(sum == target){
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
            else if(sum > target){
                end--;
            }
            else{
                start++;
            }
        }
        return result;
    }
}
