import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals_56_need_to_understand {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });         //将intervals按前一位的数组排序，[1,4],[5,6]中的1和5进行比较，大的在后面  [1,4],[5,6] => [1,4],[5,6]
                                                                                        //[1,4],[0,2] =>[0,2],[1,4]
        //必须做以上步骤，否则后面排序会出错！

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            //每次移出已经在list的最后一个数组进行比较
            int[] listInterval = list.remove(list.size() - 1);
            int[] currInterval = intervals[i];      //将要进行比较的list
            //如果前面一个数组的后一个的比后面一个数组的前一个大，则连接
            if (listInterval[1] >= currInterval[0]) {
                listInterval[1] = Math.max(currInterval[1], listInterval[1]);
                list.add(listInterval);
                //否则，将两者一起放进list中
            } else {
                list.add(listInterval);
                list.add(currInterval);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++)  res[i] = list.get(i);
        return res;
    }
    public static void main(String[] args){
        int[][] intervals = {{1,4},{0,2},{3,5}};       //interval[0][1] = 3;
        int[][] result = merge(intervals);
        int length = intervals[0].length * intervals.length;
        for(int i = 1; i < length - 1; i = i + 2){
            int X = (i - 1)/2;
            int Y = (i - 1)%2;
            int nextX = i/2;
            int nextY = i%2;
                System.out.println("[" + result[X][Y]+","+result[nextX][nextY]+"]");
            }
        }
}
