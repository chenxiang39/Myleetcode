import java.util.*;

public class Find_Right_Interval_436_need_review {
    //treeMap方法，直接调用已有的函数直接实现功能
    //Time complexity : O(N⋅logN). Inserting an element into TreeMap takes O(logN) time. N such insertions are done.
    // The search in TreeMap using ceilingEntry also takes O(logN) time. N such searches are done.
    //Space complexity : O(N). result array of size N is used. TreeMap size O(N) is used.
    //N : intervals.length
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        //key : start的值, value : Index，默认按key的大小排序
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0;  i < intervals.length; i++){
            map.put(intervals[i][0],i);
        }
        for(int i = 0; i < intervals.length; i++){
            //ceilingEntry函数 ==> 返回与大于或等于给定键的最小键关联的键-值映射关系，则返回一个键-值映射关系，
            //或者null（如果不存在这样的键）。
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        return result;
    }

    //binary search
    //Time complexity : O(nlogn). Sorting takes O(nlogn) time. Binary search takes O(logn) time for each of the n intervals.
    //Space complexity : O(n). result array of size n is used. A hashmap map of size O(n) is used.
    //n ： intervals.length
    public int[] findRightInterval_2(int[][] intervals) {
        int[] result = new int[intervals.length];
        //key : int[] interval, value : Index
        HashMap<int[], Integer> map = new HashMap<>();
        for(int i = 0;  i < intervals.length; i++){
            map.put(intervals[i],i);
        }
        //按start升序排序
        Arrays.sort(intervals,(a,b) ->(a[0] - b[0]));
        //直接使用binary search查找end在已经排好序的start中的位置
        for(int i = 0; i < intervals.length; i++){
            result[map.get(intervals[i])] = bs(intervals, map, i);
        }
        return result;
    }


    public int bs(int[][] intervals, HashMap<int[], Integer> map, int i){
        int lo = 0;
        int hi = intervals.length - 1;
        //目标end值
        int target = intervals[i][1];
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(intervals[mid][0] == target){
                return map.get(intervals[mid]);
            }

            else if(intervals[mid][0] < target){
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        //如果没有越界，就返回lo代表的Index
        if(lo != intervals.length){
            return map.get(intervals[lo]);
        }
        //越界了，说明不存在比target大的start
        return -1;
    }
}
