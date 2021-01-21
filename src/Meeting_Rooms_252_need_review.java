import java.util.Arrays;

public class Meeting_Rooms_252_need_review {
    public boolean canAttendMeetings(int[][] intervals){
        //Time complexity: O(nlogn), sort
        //Space complexity: O(logn), sort
        //按照结束时间升序排序
        Arrays.sort(intervals, (a,b) ->(a[1] - b[1]));
        for(int i = 1; i < intervals.length; i++){
            //前一个结束时间大于后一个开始时间意味着参加不了全部会议
            if(intervals[i - 1][1] > intervals[i][0]){
                return false;
            }
        }
        return true;
    }
}
