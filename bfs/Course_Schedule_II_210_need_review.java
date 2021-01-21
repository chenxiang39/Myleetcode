import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_II_210_need_review {
    //类似207
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        //初始化
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] pairs : prerequisites){
            int pre = pairs[1];
            int cur = pairs[0];
            graph[pre].add(cur);
            inDegree[cur]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[numCourses];
        int Visited = 0;        //设置上探索的指针，每在result中填上一个course，指针就往后移一位
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        //类似207
        //拓扑排序 bfs
        while(!q.isEmpty()){
            int pre = q.poll();
            result[Visited] = pre;      //上过的课进行记录
            Visited++;
            for(int cur : graph[pre]){
                inDegree[cur]--;
                if(inDegree[cur] == 0){
                    q.offer(cur);
                }
            }
        }
        return Visited == numCourses ? result : new int[0];
    }
}
