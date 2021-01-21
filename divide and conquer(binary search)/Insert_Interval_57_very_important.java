import java.util.ArrayList;
import java.util.List;

public class Insert_Interval_57_very_important {
    //binary search + two pointers
    //n : the length of intervals;
    //Time complexity: O(n), 需要补齐区域
    //Space complexity: O(n), result,list
    //通过binary search来寻找newInterval区间所划分的对应intervals中的区间，然后拼装答案


    //intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    //                     ^           ^
    //                  mid_small    mid_big

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length == 0){
            result.add(newInterval);
            int[][] r = new int[result.size()][2];
            for(int i = 0; i < result.size(); i++){
                r[i] = result.get(i);
            }
            return r;
        }
        int small = newInterval[0];
        int big = newInterval[1];
        //binary search (according to small)
        int lo = 0;
        int hi = intervals.length - 1;
        int mid_small = 0;
        while(lo <= hi){
            mid_small = lo + (hi - lo) / 2;
            if(intervals[mid_small][0] == small){
                break;
            }
            if(intervals[mid_small][0] > small){
                hi = mid_small - 1;

            }
            else{
                lo = mid_small + 1;
            }
        }
        //当前区间无法容纳small的情况(small太小)
        if(intervals[mid_small][0] > small){
            //前一个区间如果能容纳small,则将mid_small前移，否则意味着中间悬空，small不退回前一个区间
            if(mid_small > 0 && intervals[mid_small - 1][1] >= small){
                mid_small = mid_small - 1;
            }
        }
        //当前区间无法容纳small的情况，将small推到下一个区间(small太大)
        else if(intervals[mid_small][1] < small){
            mid_small = mid_small + 1;
        }
        //binary search (according to big)
        lo = 0;
        hi = intervals.length - 1;
        int mid_big = 0;
        while(lo <= hi){
            mid_big = lo + (hi - lo) / 2;
            if(intervals[mid_big][0] == big){
                break;
            }
            if(intervals[mid_big][0] > big){
                hi = mid_big - 1;

            }
            else{
                lo = mid_big + 1;
            }
        }
        //当前区间无法容纳big的情况，将big退回上一个区间(big太小)
        if(intervals[mid_big][0] > big){
            mid_big = mid_big - 1;
        }
        //补齐之前的非交集区域
        for(int i = 0; i < mid_small; i++){
            result.add(intervals[i]);
        }
        //将中间区域混合
        int[] middle = new int[2];
        middle[0] = mid_small < intervals.length ? Math.min(intervals[mid_small][0],small) : small;     //需要考虑newInterval区间大于所有已知空间而产生的无法容纳的情况
        middle[1] = mid_big > -1 ? Math.max(intervals[mid_big][1],big) : big;       //需要考虑newInterval区间小于所有已知空间而产生的无法容纳的情况
        result.add(middle);

        //补齐之后的非交集区域
        for(int i = mid_big + 1; i < intervals.length; i++){
            result.add(intervals[i]);
        }
        //转换答案
        int[][] r = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            r[i] = result.get(i);
        }
        return r;
    }
}
