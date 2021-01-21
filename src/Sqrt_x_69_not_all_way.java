public class Sqrt_x_69_not_all_way {
    //Binary Search
    public static int mySqrt(int x) {
        if(x == 1){
            return 1;
        }
        long lo = 0;
        long hi = x;
        while(lo <= hi){
            long mid = lo + (hi - lo)/2;    //long型，防止出现mid * mid超过2147483647
            if(mid * mid == x){
                return (int)mid;
            }
            if(mid * mid > x){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return (int)lo - 1;     //没有mid * mid 的正好的情况，则输出lo - 1，因为取小的
    }
    public static void main(String[] args){
        System.out.println(mySqrt(2147395599));
    }
}
