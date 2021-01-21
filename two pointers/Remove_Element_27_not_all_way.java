public class Remove_Element_27_not_all_way {
    //two pointer
    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int start = -1;     //设置-1是因为end从0开始扫描，在处理start++时防止溢出
        for (int end = 0; end < nums.length;end++){
            if(nums[end] != val){       //遇到不同的值
                start++;                //start值向后推一位
                nums[start] = nums[end];        //存储不同的值
            }
            else {          //如果遇到相同的，则end指针直接向后
                continue;
            }
        }
        return start + 1;           //因从-1开始计，故加1
    }
    public static void main(String[] args){
        int[] nums = {3,1,1,2,3,3,4,4,4};
        System.out.println(removeElement(nums,3));
    }
}
