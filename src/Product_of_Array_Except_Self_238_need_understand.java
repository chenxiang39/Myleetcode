public class Product_of_Array_Except_Self_238_need_understand {
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int[] productExceptSelf(int[] nums) {
        int wholeProduct = 1;
        int wholeProductIncludeZero = 0;       //include zero's product
        int zeroNumber = 0;
        for(int num : nums){
            if(num!= 0){
                wholeProduct = num * wholeProduct;      //not include zero's product
            }
            else{
                zeroNumber++;
            }
            wholeProductIncludeZero = num * wholeProductIncludeZero;
        }
        for(int i = 0; i < nums.length; i++){
            //if the number of zero >= 2, all is zero
            if(zeroNumber >= 2){
                nums[i] = 0;
            }
            else{
                //check whether contain zero, if contain, return 0, else, wholeProductIncludeZero == wholeProduct
                if(nums[i] != 0){
                    nums[i] =  wholeProductIncludeZero / nums[i];
                }
                //include one zero,return the product of other non-zero Numbers
                else{
                    nums[i] = wholeProduct;
                }
            }
        }
        return nums;
    }
}
