import java.util.LinkedList;
import java.util.Queue;


public class The_Maze_II_505_need_review {
    //bfs
    //https://blog.csdn.net/fuxuemingzhu/article/details/101056461
    // 题目要我们求最少的移动步数，很显然我们使用BFS解决。一般的迷宫问题只会移动一个格子，
    // 但是这个题目要求我们撞到墙壁才停止，所以我们需要遍历四个方向，判断四个方向分别撞到墙壁时移动的步数和结束位置。
    // 当小球移动到该结束位置总的步数比历史上所有的位置都小，该结束位置放入队列中。
    // 一般BFS需要有个visited数组，用来判断每个位置是否访问过，从而判断新位置是否加入队列中。
    // 但是这个题目不需要，因为只有当到达一个结置位置总的步数比以前到达这个位置的步数小的时候，才会加入队列，所以是有限制条件的，结果会是有限的，不会无限循环下去。
    // 代码里使用了dp作为访问每个位置的最小步数，默认是INT_MAX。从起点开始，计算出小球能访问到的所有位置，
    // 直至再运动已经不能让所有可以停止的点的访问步数缩小时停止。最后返回结束位置的步数。

    //类似490，只不过需要dis数组记录到达的距离并更新
    //代码参考：https://leetcode.com/problems/the-maze-ii/discuss/380843/BFS-Java-Solution
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze.length == 0){
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};     //上，下，左，右
        int[][] dis = new int[maze.length][maze[0].length];
        q.offer(start);
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[start[0]][start[1]] = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int step = 0;
                    int curx = cur[1];
                    int cury = cur[0];
                    int nx = cur[1] + dir[1];
                    int ny = cur[0] + dir[0];
                    while(nx < maze[0].length && nx >= 0 && ny < maze.length && ny >= 0 && maze[ny][nx] != 1){
                        cury = ny;
                        curx = nx;
                        step++;
                        nx += dir[1];
                        ny += dir[0];
                    }
                    if(dis[cur[0]][cur[1]] + step < dis[cury][curx]){
                        dis[cury][curx] = dis[cur[0]][cur[1]] + step;
                        q.offer(new int[]{cury, curx});
                    }
                }
            }
        }
        return dis[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dis[destination[0]][destination[1]];
    }
}
