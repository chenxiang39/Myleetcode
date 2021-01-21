public class Plus_one_66_not_all_way {
    //my way
    //Time complexity: O(n),n为digits数组的元素个数
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean exceptionFlag = true;
        //T: O(n)
        for (int i = 0; i < length; i++){
            if(digits[i] != 9){
                exceptionFlag = false;
                break;
            }
        }
        //特殊情况，全部是9，空间复杂度：O(n)
        if(exceptionFlag){
            int[] result = new int[length + 1];
            result[0] = 1;
            for (int j = 1 ; j < length + 1; j++){
                result[j] = 0;
            }
            return result;
        }
        //空间复杂度：O(1);
        int carry = 1;  //进位
        int pointer = length - 2;
        digits[length - 1] = (digits[length - 1] + 1)%10;
        int origin;
        //T: O(n)
        while (carry != 0){         //一旦不进位则结束循环，因为全是9的特殊情况已经被排除
            //如果digits的最后一位原本是9
            if(digits[length - 1] == 0){
                origin = digits[pointer] + carry;       //记录前一位的数字
                digits[pointer] = origin%10;        //放入数字
                carry = origin/10;          //计算进位
                pointer--;
            }
            else {
                break;
            }
        }
        return digits;
    }
    public static void main(String[] args){
        int[] nums = {9,9,9,9};
        nums = plusOne(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
