public class Power_of_two_231_need_understand_other_way {
    //Time complexity: O(logn)
    //Space complexity: O(1)
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        //一直除以2，直到1
        while(n % 2 != 1){
            n = n / 2;
        }
        //看最后是否为1,不为1说明不是，因为2的0次方为1
        return n == 1;
    }
}
