import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Valid_Tree_261_very_very_important {
    //bfs
    //时间复杂度：O(点的数量 + 边的数量)
    //空间复杂度：O(点的数量 + 2 * 边的数量(graph) + 点的数量(visited)) => O(点的数量 + 边的数量)
    //https://www.cnblogs.com/grandyang/p/5257919.html
    public boolean validTree(int n, int[][] edges) {
        HashSet<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<>();
        }

        for(int[] pairs : edges){
            int pre = pairs[0];
            int cur = pairs[1];
            graph[pre].add(cur);
            graph[cur].add(pre);
        }

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);     //加入已访问节点
        while(!q.isEmpty()){
            int curNode = q.poll();
            for(int neighbor : graph[curNode]){
                if(visited.contains(neighbor)){      //产生环路，之前有其他节点与当前节点有一样的邻居节点
                    return false;
                }
                visited.add(neighbor);       //加入已访问节点（直接将邻居节点加到visited中，不要在出队列的时候添加）, bfs
                graph[neighbor].remove(curNode);     //删除邻居节点到当前节点的连接，防止访问到邻居节点时产生重复访问的情况
                q.offer(neighbor);
            }
        }
        return visited.size() == n;     //是否访问了全部节点
    }
}
