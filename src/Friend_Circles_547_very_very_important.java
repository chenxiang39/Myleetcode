import java.util.LinkedList;
import java.util.Queue;

public class Friend_Circles_547_very_very_important {
    //dfs
    //Time complexity: O(M.length * M.length), The complete matrix of size M.length^2 is traversed.
    //Space complexity: O(M.length) => isVis
    public int findCircleNum(int[][] M) {
        int result = 0;
        boolean[] isVis = new boolean[M.length];        //this people whether is visited
        for (int i = 0; i < M.length; i++){
            if(!isVis[i]){                  //if is not visited, new friend circle
                result++;
                dfs(isVis, M, i);           //dfs his friend list
            }
        }
        return result;
    }

    public void dfs(boolean[] isVis, int[][] M, int i){
        if(isVis[i]){
            return;
        }
        isVis[i] = true;
        for(int j = 0; j < M[i].length ; j++){
            if(i == j){
                continue;               //can not dfs himself
            }
            if(M[i][j] == 1){
                dfs(isVis, M, j);       //dfs his friend
            }
        }
    }


    //bfs
    //Time complexity: O(M.length * M.length), The complete matrix of size M.length^2 is traversed.
    //Space complexity: O(M.length) => isVis
    public int findCircleNum_2(int[][] M) {
        int result = 0;
        boolean[] isVis = new boolean[M.length];
        for (int i = 0; i < M.length; i++){
            if(!isVis[i]){          //new friend circle
                result++;
                bfs(isVis, M, i);
            }
        }
        return result;
    }

    public void bfs(boolean[] isVis, int[][] M, int i){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        isVis[i] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int j = 0; j < M[cur].length; j++){
                if(cur == j){           //himself cannot put into queue
                    continue;
                }
                if(!isVis[j] && M[cur][j] == 1){
                    q.offer(j);         //put all cur's friend(is not visited) into queue
                    isVis[j] = true;    //mark new people is visited;
                }
            }
        }
    }
}
