import java.util.Arrays;

public class Non_overlapping_Intervals_435_need_review {
    //greedy
    //贪心策略：更新min的界限和max的界限，使max尽量小(这样就能最小化产生重合的可能)，同时根据数组对左侧的小数字进行排序，
    //删掉会使max更大的可能组合，因为max越大，越可能与后面的数组对重合
    //时间复杂度：O(nlogn),sort, n :  intervals.length
    //空间复杂度：O(1)
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        Arrays.sort(intervals,(a, b) ->
                {
                    if(a[0] != b[0]){
                        return a[0] - b[0];
                    }
                    else{
                        return a[1] - b[1];
                    }
                }
        );
        //表示到目前位置的pair的范围
        int min = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] pair : intervals){
            //载入第一队pair并更新min和max
            if(min == Integer.MIN_VALUE && max == Integer.MIN_VALUE){
                min = pair[0];
                max = pair[1];
            }
            else{
                //如果下一组pair的小的数字小于当前的max，说明有重合,需要删除一组pair
                if(pair[0] < max){
                    result++;
                    //如果新的pair的大的数字比max小,就用新的pair代替原来的pair(需要保证max尽量小)
                    if(max > pair[1]){
                        min = pair[0];
                        max = pair[1];
                    }
                }
                //如果下一组pair的小的数字大于等于当前的max，说明无重合，直接更新min和max
                else{
                    min = pair[0];
                    max = pair[1];
                }
            }
        }
        return result;
    }
}
