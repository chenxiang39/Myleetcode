import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Count_of_Smaller_Numbers_After_Self_315_need_review {
    // https://blog.csdn.net/qq_35923749/article/details/85218769
    // binary search
    // 从右边开始遍历，同时不断把已经遍历过的数字放到另外一个sort数组中，
    // 并且对这个sort数组进行升序存储，所以，如果要找当前数值右边有几个比它小的个数，
    // 那么就是要找到当前数值应该放入到sort数组中的位置（为了提高效率，使用二分查找法来确定当前数值应该放入的位置），即是它右边有几个比它小的个数。
    // 时间复杂度：O(n * log N)
    // 空间复杂度： O(n),sort数组
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        List<Integer> sortedArray = new ArrayList<>();
        //倒序扫描
        for(int i = n - 1; i >= 0; i--){
            result.add(bs(sortedArray, nums[i]));
        }
        Collections.reverse(result);
        return result;
    }

    public int bs(List<Integer> sortedArray, int target){
        if(sortedArray.isEmpty()){
            sortedArray.add(0,target);
            return 0;
        }
        int lo = 0;
        int hi = sortedArray.size();
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(sortedArray.get(mid) >= target){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        sortedArray.add(lo,target);
        //返回当前target将要插入到sortedArray的位置，即题目要求的数字
        return lo;
    }
}
