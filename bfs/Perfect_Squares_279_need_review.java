import java.util.LinkedList;
import java.util.Queue;

public class Perfect_Squares_279_need_review {
    //bfs
    //https://www.cnblogs.com/qinyuguan/p/11441570.html
    //BFS的话，我们可以一层一层的算。第一层依次减去一个平方数得到第二层，第二层依次减去一个平方数得到第三层。直到某一层出现了 0，此时的层数 - 1就是我们要找到平方数和的最小个数。
    //举个例子，n = 12，每层的话每个节点依次减 1, 4, 9...。
    //当出现 0 的时候遍历就可以停止，此时是第 4 层（从 0 计数），所以最终答案就是 3。
    public int numSquares(int n) {
        int res = 0;
        boolean[] isVis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        while(q != null){
            res++;
            int size = q.size();
            for(int j = 0; j < size; j++){
                int cur = q.poll();
                isVis[cur] = true;
                if(cur == 0){
                    return res - 1;     //输出层数 - 1
                }
                int max = (int) Math.sqrt(cur);
                for(int i = 1; i <= max; i++){
                    int aux = cur - (int)Math.pow(i,2);
                    if(!isVis[aux]){
                        q.offer(aux);
                    }
                }
            }
        }
        return res - 1;
    }
}
