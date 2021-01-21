import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Room_II_253_very_very_important {
    //https://www.cnblogs.com/grandyang/p/5244720.html
    //这种方法先把所有的时间区间按照起始时间排序，然后新建一个最小堆，开始遍历时间区间，如果堆不为空，且首元素小于等于当前区间的起始时间，去掉堆中的首元素，把当前区间的结束时间压入堆，由于最小堆是小的在前面，那么假如首元素小于等于起始时间，说明上一个会议已经结束，可以用该会议室开始下一个会议了，所以不用分配新的会议室，遍历完成后堆中元素的个数即为需要的会议室的个数
    //greedy
    //use min heap
    //N: the length of intervals
    //Time complexity: O(N log * N);
    //Space complexity: O(N);   min heap
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) ->(a[0] - b[0]));
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
        for(int i = 0; i < intervals.length; i++){
            if(minPQ.isEmpty()){
                minPQ.offer(intervals[i][1]);
            }
            else{
                //最早结束的时间进行比较
                if(minPQ.peek() > intervals[i][0]){
                    minPQ.offer(intervals[i][1]);
                }
                else{
                    minPQ.poll();
                    minPQ.offer(intervals[i][1]);
                }
            }
        }
        return minPQ.size();
    }
}
