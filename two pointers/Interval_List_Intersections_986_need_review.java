import java.util.ArrayList;
import java.util.List;

public class Interval_List_Intersections_986_need_review {
    //two pointers
    //https://www.bilibili.com/video/BV1bT4y1g7Bn
    //时间复杂度：O(A.length + B.length)
    //空间复杂度：O(A.length + B.length), result
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        while(i < A.length && j < B.length){
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            //intersection的情况
            if(hi >= lo){
                result.add(new int[]{lo,hi});
            }
            //不论相不相交都需要更新坐标
            //更新坐标，将靠前的条子去掉(比较后半部分的大小)
            if(A[i][1] > B[j][1]){
                j++;
            }
            else{
                i++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
