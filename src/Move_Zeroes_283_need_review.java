public class Move_Zeroes_283_need_review {
    //two pointers
    //这里使用了两个索引，一个指向0，一个指向非0，二者分别向后遍历，当出现一对（0，非0）时，交换二者位置，这样当遍历到结束时，此时0也就被移动到了最后。
    //因为每个节点最多被访问两次，所以时间复杂度为O(n).
    public void moveZeroes(int[] nums) {
        int findZero = 0;   //指向0
        int iter = 0;       //指向非0
        while(iter < nums.length){
            //遇到不是0的情况，两指针同时向后
            if(nums[findZero] != 0){
                findZero++;
                iter++;
            }
            //遇到了0，则iter指针向后查找，直到遇到非0元素，然后交换findZero（此时指向0）和iter指针的内容，然后两指针继续向后一位
            else{
                while(iter < nums.length - 1 && nums[iter] == 0){
                    iter++;
                }
                swap(findZero, iter, nums);
                iter++;
                findZero++;
            }
        }
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
