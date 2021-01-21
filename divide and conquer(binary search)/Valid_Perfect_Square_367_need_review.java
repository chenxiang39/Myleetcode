public class Valid_Perfect_Square_367_need_review {
    //binary search
    //从num/2开始二分搜索找平方根，找得到就返回true，否则就是false
    //时间复杂度：O(logN), N = num
    //空间复杂度：O(1)
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        int lo = 1;
        int hi = num / 2;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if((long)mid * mid == num){
                return true;
            }
            else if((long)mid * mid > num){
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
