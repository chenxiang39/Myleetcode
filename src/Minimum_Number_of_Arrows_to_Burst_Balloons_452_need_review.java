import java.util.Arrays;

public class Minimum_Number_of_Arrows_to_Burst_Balloons_452_need_review {
    //greedy
    //贪心策略：更新max的界限，使max尽量大(能尽量跨入后面一个pair的范围)，同时根据数组end数字进行升序排序，
    //时间复杂度：O(nlogn),sort, n :  points.length
    //空间复杂度：O(1)
    public int findMinArrowShots(int[][] points) {
        int result = 0;
        //按end升序
        Arrays.sort(points, (a, b) -> {
            //直接返回1，0，-1是因为防止值溢出，比如2147483647 - （-2147483640）将会小于0
            if(a[1] > b[1]){
                return 1;
            }
            else if(a[1] == b[1]){
                return 0;
            }
            else{
                return -1;
            }
        });
        int max = Integer.MIN_VALUE;
        for(int[] pair : points){
            //初始载入，设置max是第一个pair的end值(尽量最大化)
            if(max == Integer.MIN_VALUE){
                result++;
                max = pair[1];
            }
            else{
                //如果之后的pair的小的值也比max大，说明一定需要新的箭涉及新的pair区域
                if(pair[0] > max){
                    //更新结果
                    result++;
                    //更新max为新pair的end值
                    max = pair[1];
                }
            }
        }
        return result;
    }
}
