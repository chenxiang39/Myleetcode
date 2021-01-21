import java.util.Arrays;

public class Maximum_Product_of_Three_Numbers_628_need_remember {
    //sort way
    public int maximumProduct(int[] nums) {
        //don't like LC 152
        //n : the length of nums
        //Time complexity:O(nlogn);
        //Space complexity:O(logn);
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 1] * nums[length - 2] * nums[length - 3]);
    }

    //pointer
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int maximumProduct_2(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;             //min2 > min1(smallest)
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;   //max1(biggest) > max2 > max3
        for(int n: nums){
            if(n < min1){
                min2 = min1;
                min1 = n;
            }
            else if(n < min2){
                min2 = n;
            }

            if(n >= max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if(n >= max2){
                max3 = max2;
                max2 = n;
            }
            else if(n >= max3){
                max3 = n;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
