public class Find_Smallest_Letter_Greater_Than_Target_744_need_review {
    //binary search
    //时间复杂度：O(logN)， N = letters.length
    //空间复杂度：O(1)
    //简单的二分查找，如果找的字母比数组最大的字母还大，则返回第一个元素
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            //必须hi = mid, 而不是 hi = mid - 1,因为当letters[mid]大于target时，letters[mid]可能是最终答案，而当letters[mid]不大于target时，letters[mid]不可能是最终答案
            if(letters[mid] > target){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        if(target >= letters[lo]){
            return letters[0];
        }
        return letters[lo];
    }
}
