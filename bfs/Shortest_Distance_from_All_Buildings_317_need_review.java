import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Distance_from_All_Buildings_317_need_review {
    public int shortestDistance(int[][] grid) {
        int h = grid.length;
        int l = grid[0].length;
        //记录每个点能到的building的数量，如果没有达到总的building的数量，说明这个点不能达到全部的building,不算结果
        int[][] visCount = new int[h][l];
        //记录所有楼的数量
        int building = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < l; j++){
                //从building开始运行bfs
                if(grid[i][j] == 1){
                    bfs(grid, i, j,visCount);
                    building++;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < l; j++){
                if(visCount[i][j] == building){
                    result = Math.min(result, Math.abs(grid[i][j]));//距离取绝对值，因为记录的是负数
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public void bfs(int[][] grid, int y, int x, int[][] visCount){
        Queue<int[]> q = new LinkedList<>();
        int[] curpos = new int[2];
        int dis = -1;
        curpos[0] = y;
        curpos[1] = x;
        q.offer(curpos);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[y][x] = true;
        while(!q.isEmpty()){
            int size = q.size();
            dis++;
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int cury = cur[0];
                int curx = cur[1];
                if(dis != 0){
                    grid[cury][curx] -= dis;    //距离是负数，防止与1，2冲突，此处直接在grid上更改每个building到这个点的距离
                    visCount[cury][curx]++;
                }

                //上
                if(cury - 1 >= 0 && !visited[cury - 1][curx] && grid[cury - 1][curx] != 1 && grid[cury - 1][curx] != 2){
                    int[] pa = new int[2];
                    pa[0] = cury - 1;
                    pa[1] = curx;
                    q.offer(pa);
                    visited[cury - 1][curx] = true; //在进入之前就要更改isVis的标记，以防止当前队列插入同一个点（同一层的点在bfs搜索中可能会遇到同一个点）
                }
                //下
                if(cury + 1 < grid.length && !visited[cury + 1][curx] && grid[cury + 1][curx] != 1 && grid[cury + 1][curx] != 2){
                    int[] pd = new int[2];
                    pd[0] = cury + 1;
                    pd[1] = curx;
                    q.offer(pd);
                    visited[cury + 1][curx] = true;
                }
                //左
                if(curx - 1 >= 0 && !visited[cury][curx - 1] && grid[cury][curx - 1] != 1 && grid[cury][curx - 1] != 2){
                    int[] pl = new int[2];
                    pl[0] = cury;
                    pl[1] = curx - 1;
                    q.offer(pl);
                    visited[cury][curx - 1] = true;
                }
                //右
                if(curx + 1 < grid[0].length && !visited[cury][curx + 1] && grid[cury][curx + 1] != 1 && grid[cury][curx + 1] != 2){
                    int[] pr = new int[2];
                    pr[0] = cury;
                    pr[1] = curx + 1;
                    q.offer(pr);
                    visited[cury][curx + 1] = true;
                }
            }
        }
    }
}
