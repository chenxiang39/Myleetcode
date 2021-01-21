import java.util.*;

public class Minimum_Height_Trees_310_need_review {
    //拓扑排序
    //https://www.cnblogs.com/grandyang/p/5000291.html以及leetcode的solution
    //方法是一个类似剥洋葱的方法，就是一层一层的褪去叶节点，最后剩下的一个或两个节点就是我们要求的最小高度树的根节点，这种思路非常的巧妙，
    //而且实现起来也不难，跟之前那到课程清单的题一样，我们需要建立一个图g，是一个二维数组，其中g[i]是一个一维数组，保存了i节点可以到达的所有节点。
    //我们开始将所有只有一个连接边的节点(叶节点)都存入到一个list中，然后我们遍历每一个叶节点，通过图来找到和其相连的节点，并且在其相连节点的集合中将该叶节点删去，
    //如果删完后此节点也也变成一个叶节点了，加入队列中，再下一轮删除。那么我们删到什么时候呢，当节点数小于等于2时候停止，此时剩下的一个或两个节点就是我们要求的最小高度树的根节点
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new HashSet<>());
        }
        //构建邻接图
        for(int[] pairs : edges){
            int pre = pairs[0];
            int cur = pairs[1];
            graph.get(pre).add(cur);
            graph.get(cur).add(pre);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(graph.get(i).size() == 1){
                leaves.add(i);
            }
        }

        while(n > 2){
            n = n - leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves){
                //获取叶子节点的唯一邻居
                int neighbour = graph.get(leaf).iterator().next();
                //邻居节点的邻居节点集合中删除叶子节点
                graph.get(neighbour).remove(leaf);
                if(graph.get(neighbour).size() == 1){
                    newLeaves.add(neighbour);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
