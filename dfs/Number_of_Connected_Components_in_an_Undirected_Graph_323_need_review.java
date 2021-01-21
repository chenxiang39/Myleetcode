import java.util.ArrayList;
import java.util.List;

public class Number_of_Connected_Components_in_an_Undirected_Graph_323_need_review {
    //unionfind的方法，两点之间有边就union起来，参考leetcode 200的uf解释
    public class unionfind{
        int[] size;
        int[] id;
        int count;
        public unionfind(int n,int count){
            size = new int[n];
            id = new int[n];
            for(int i = 0; i < n; i++){
                size[i] = 1;
                id[i] = i;
            }
            this.count = count;
        }
        public int getCount(){
            return count;
        }
        public int root(int i){
            while(i != id[i]){
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        public void union(int i, int j){
            int ir = root(i);
            int jr = root(j);
            if(ir == jr){
                return;
            }
            if(size[ir] >= size[jr]){
                id[jr] = ir;
                size[ir] += size[jr];
            }
            else{
                id[ir] = jr;
                size[jr] += size[ir];
            }
            count--;
        }
    }
    //dfs
    public int countComponents_2(int n, int[][] edges) {
        unionfind uf = new unionfind(n,n);
        for(int[] pairs : edges){
            uf.union(pairs[0], pairs[1]);
        }
        return uf.getCount();
    }

    public int countComponents(int n, int[][] edges) {
        boolean[] isVisited = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];   //创建图，每个点都有一个list代表相邻点
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList();
        }
        for(int[] pairs : edges){
            int p1 = pairs[0];
            int p2 = pairs[1];
            graph[p1].add(p2);
            graph[p2].add(p1);
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            //从没访问过的点开始访问
            if(!isVisited[i]){
                dfs(isVisited, graph, i);
                result++;   //结果加1
            }
        }
        return result;
    }
    //一直深度遍历没访问过的相邻节点
    public void dfs(boolean[] isVisited, List<Integer>[] graph, int i){
        if(isVisited[i]){
            return;
        }
        isVisited[i] = true;
        for(int nextNode : graph[i]){
            dfs(isVisited, graph, nextNode);
        }
    }


}
