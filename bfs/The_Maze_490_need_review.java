import java.util.LinkedList;
import java.util.Queue;

public class The_Maze_490_need_review {
    //bfs
    //思想是leetcode题解的第二个方法，记录一路走到底的那个space并记录已经访问并加进队列，然后在出队列的时候与目的地进行比对
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        while(maze.length == 0){
            return true;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVis = new boolean[maze.length][maze[0].length];
        isVis[start[0]][start[1]] = true;
        q.offer(start);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curx = cur[1];
            int cury = cur[0];
            if(cur[0] == destination[0] && cur[1] == destination[1]){
                return true;
            }

            //上
            int moveA = cur[0];
            while(moveA - 1 >= 0 && maze[moveA - 1][curx] == 0){
                moveA--;
            }
            //说明更换了位置
            if(moveA != cur[0] &&  !isVis[moveA][curx]){
                isVis[moveA][curx] = true;
                int[] moveAp = new int[2];
                moveAp[0] = moveA;
                moveAp[1] = curx;
                q.offer(moveAp);
            }

            //下
            int moveD = cur[0];
            while(moveD + 1 < maze.length && maze[moveD + 1][curx] == 0){
                moveD++;
            }
            //说明更换了位置
            if(moveD != cur[0]  && !isVis[moveD][curx]){
                isVis[moveD][curx] = true;
                int[] moveDp = new int[2];
                moveDp[0] = moveD;
                moveDp[1] = curx;
                q.offer(moveDp);
            }

            //左
            int moveL = cur[1];
            while(moveL - 1 >= 0 && maze[cury][moveL - 1] == 0){
                moveL--;
            }
            //说明更换了位置
            if(moveL != cur[1] && !isVis[cury][moveL]){
                isVis[cury][moveL] = true;
                int[] moveLp = new int[2];
                moveLp[0] = cury;
                moveLp[1] = moveL;
                q.offer(moveLp);
            }

            //右
            int moveR = cur[1];
            while(moveR + 1 < maze[0].length && maze[cury][moveR + 1] == 0){
                moveR++;
            }
            //说明更换了位置
            if(moveR != cur[1] && !isVis[cury][moveR]){
                isVis[cury][moveR] = true;
                int[] moveRp = new int[2];
                moveRp[0] = cury;
                moveRp[1] = moveR;
                q.offer(moveRp);
            }
        }
        return false;
    }
}
