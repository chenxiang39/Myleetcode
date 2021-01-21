public class Arranging_Coins_441_need_review {
    //binary search
    //Time complexity : O(logN).
    //Space complexity : O(1)
    //根据公式 1 + 2 + 3 + ... + k = (1 + k ) * k / 2得来
    //只要(1 + k ) * k / 2 <= n 即可,使用binary search查找k(sqrt(k) -- k范围做尝试)
    public int arrangeCoins(int n) {
        if(n == 0){
            return 0;
        }
        long lo = (long)Math.sqrt(n);
        long hi = n;
        while(lo <= hi){
            long mid = lo + (hi - lo) / 2;
            long sum = mid * (mid + 1) / 2;
            if(sum == n){
                return (int)mid;
            }
            else if(sum > n){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return (int)hi;
    }
}
