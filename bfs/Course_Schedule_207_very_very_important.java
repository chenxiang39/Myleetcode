import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_207_very_very_important {
    //https://www.bilibili.com/video/BV1A5411x7qH?from=search&seid=12227424055411077805
    //时间复杂度是O(V + E), V表示课程个数，E为prerequisites中的长度（图中的边数），要遍历每个点和边
    //空间复杂度是O(2 * V + E) == O(V + E), inDegree保存了点的信息， graph保存了边和点
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create graph
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];       //入度

        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList();
        }
        for(int[] pairs : prerequisites){       //每一个边都添加进graph
            int pre = pairs[1];
            int cur = pairs[0];
            graph[pre].add(cur);        //graph存放后面能上的课的列表
            inDegree[cur]++;
        }
        //bfs
        //topological sort
        Queue<Integer> q = new LinkedList<>();
        int Visited = 0;        //上过的课的个数
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);             //将没有前置课程的课先加入队列
            }
        }

        while(!q.isEmpty()){
            int pre = q.poll();
            Visited++;      //一门课程上完
            //遍历以当前课为前置课的所有课
            for(int cur : graph[pre]){
                inDegree[cur]--;        //入度减1，因为上完了一门前置课
                if(inDegree[cur] == 0){     //入度为0的课加入队列，因为这门课的前置课程都上完了
                    q.offer(cur);
                }
            }
        }
        return Visited == numCourses;
    }

    //https://blog.csdn.net/level_code/article/details/89854681
}
