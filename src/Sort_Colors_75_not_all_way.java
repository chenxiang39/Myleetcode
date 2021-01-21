public class Sort_Colors_75_not_all_way {
    //two pointer
    //时间复杂度：O(N),N: the length of nums
    //空间复杂度：O(1),双指针
    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                swap(nums,start,i);
                start++;        //交换完，start向后进一位,start之前都是0
            }
            if (i == end){      // end 之后的都是2，本身就在最后，故结束循环
                break;
            }
            else if(nums[i] == 2){
                swap(nums,end,i);
                end--;
                i--;        //i要回退，因为不知道end交换过来的是什么，需要重新计算
            }
        }
    }
    private static void swap(int[] nums,int i, int j){
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
    public static void main(String[] args){
        int[] nums = {1,0,1,1,1,0};
        sortColors(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }
}
