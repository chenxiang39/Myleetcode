import java.util.Arrays;

public class Set_Intersection_Size_At_Least_Two_757_need_understand {
    //https://www.cnblogs.com/grandyang/p/8503476.html
    //time complexity: O(nlogn);    //排序
    //space complexity: O(logn);    //排序
    public int intersectionSizeTwo(int[][] intervals) {
        //按b(即区间中大的那个数字)的大小升序排序
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        int max1 = -1, max2 = -1, result = 0;
        for(int[] pairs: intervals){
            int small = pairs[0];
            int big = pairs[1];
            //无交集
            if(small > max1){
                result += 2;
                max1 = big;
                max2 = big - 1;
            }
            //有交集,但不完全包含
            else if(small > max2){
                result++;
                max2 = max1 == big ? max1 - 1 : max1;
                max1 = big;
            }
            //完全包含则不处理
        }
        return result;
    }
}
