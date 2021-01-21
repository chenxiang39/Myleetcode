import java.util.LinkedList;
import java.util.Queue;

public class Walls_and_Gates_286_need_review {
    private class position{
        int x;
        int y;
        public position(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    //bfs
    //从每一个INF点进行bfs,寻找最短能到0的路径并进行填写，因为要求最短能到0的长度，因此使用bfs(bfs => 找最短路径)
    public void wallsAndGates(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == Integer.MAX_VALUE){
                    bfs(rooms, j, i);
                }
            }
        }
    }
    //x和y代表当前点的位置
    public void bfs(int[][] rooms, int x, int y){
        int res = -1;
        Queue<position> q = new LinkedList<>();
        position p = new position(y,x);
        q.offer(p);
        boolean[][] isVis = new boolean[rooms.length][rooms[0].length];
        boolean flag = false;       //当前是否已经找到答案，需要停止bfs遍历
        while(!q.isEmpty() && !flag){
            int size = q.size();
            res++;
            for(int i = 0; i < size; i++){
                position cur = q.poll();
                int curx = cur.x;
                int cury = cur.y;
                isVis[cury][curx] = true;
                //达到0，修改数组并停止bfs
                if(rooms[cury][curx] == 0){
                    rooms[y][x] = res;
                    flag = true;
                    break;
                }
                //上
                if(cury - 1 >= 0 && rooms[cury - 1][curx] != -1 && !isVis[cury - 1][curx]){
                    position pa = new position(cury - 1, curx);
                    q.offer(pa);
                }
                //下
                if(cury + 1 < rooms.length && rooms[cury + 1][curx] != -1  && !isVis[cury + 1][curx]){
                    position pd = new position(cury + 1, curx);
                    q.offer(pd);
                }
                //左
                if(curx - 1 >= 0 && rooms[cury][curx - 1] != -1  && !isVis[cury][curx - 1]){
                    position pl = new position(cury, curx - 1);
                    q.offer(pl);
                }
                //右
                if(curx + 1 < rooms[0].length && rooms[cury][curx + 1] != -1 && !isVis[cury][curx + 1]){
                    position pr = new position(cury, curx + 1);
                    q.offer(pr);
                }
            }
        }
    }
}
