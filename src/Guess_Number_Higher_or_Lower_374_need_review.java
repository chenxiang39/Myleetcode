public class Guess_Number_Higher_or_Lower_374_need_review {
    //简单的binary search
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
//            if(guess(mid) == 0){
//                return mid;
//            }
//            else if(guess(mid) > 0){
//                lo = mid + 1;
//            }
//            else{
//                hi = mid - 1;
//            }
        }
        return 1;
    }
}
