import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queue_Reconstruction_by_Height_406_need_review {
    //greedy
    //贪心策略：首先对这个序列进行排序，按照身高从高到低的顺序进行排序，如果身高相同，那就按照前面还是否有人的顺序，来进行排列，因为身高高的人可以优先被确认位置。
    //https://blog.csdn.net/lym940928/article/details/89352588
    //时间复杂度:O(n^2), n: people.length, 插入的时候是k(按当前list排) * n ==> n^2
    //空间复杂度：O(n),result
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people,(a, b) ->
                {
                    //身高按降序排列
                    if(b[0] != a[0]){
                        return b[0] - a[0];
                    }
                    //身高相同的情况下，按k升序排列
                    else{
                        return a[1] - b[1];
                    }
                }
        );
        //按k的位置插入，因为之后的身高都小于等于当前的身高，k的要求需要被满足
        for(int[] pair : people){
            result.add(pair[1], pair);
        }
        return result.toArray(new int[result.size()][]);
    }
}
