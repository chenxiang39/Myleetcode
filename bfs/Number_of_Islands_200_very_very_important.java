import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Islands_200_very_very_important {
    //dfs
    //Time complexity : O(M × N) where M is the number of rows and N is the number of columns.
    //Space complexity : worst case O(M × N) in case that the grid map is filled with lands where DFS goes by M × N deep.
    //isVis数组的空间同样是M × N
    //https://www.jianshu.com/p/23a139d0c2b6
    public int numIslands(char[][] grid) {
        //corner case
        if(grid.length == 0){
            return 0;
        }
        int result = 0;
        boolean[][] isVis = new boolean[grid.length][grid[0].length];     //是否访问过该点
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !isVis[i][j]){          //如果遇到从未被访问过的非0区域
                    result++;                             //结果加1
                    dfs(isVis, grid, i, j);             //进行dfs,更新isVis
                }
            }
        }
        return result;
    }
    private void dfs(boolean[][] isVis, char[][] grid, int height, int length){
        //越界或者已经被访问过
        if(height < 0 || height > grid.length  - 1|| length < 0 || length > grid[0].length  - 1|| isVis[height][length]){
            return;
        }
        //遇到水域
        if(grid[height][length] == '0'){
            return;
        }
        //更新isVis
        isVis[height][length] = true;
        //上下左右深度搜索
        dfs(isVis, grid, height - 1, length);
        dfs(isVis, grid, height + 1, length);
        dfs(isVis, grid, height , length - 1);
        dfs(isVis, grid, height , length + 1);
    }

    //bfs
    //Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
    //Space complexity : O(min(M,N)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,N).
    public int numIslands_2(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int result = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!isVisited[i][j] && grid[i][j] == '1'){      //如果遇到从未被访问过的非0区域
                    result++;                   //结果加1
                    bfs(isVisited, grid, i, j);         //进行bfs
                }
            }
        }
        return result;
    }
    private void bfs(boolean[][] isVisited, char[][] grid, int height, int length){
        int[] cur = new int[2];     //保存坐标
        cur[0] = height;
        cur[1] = length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(cur);
        isVisited[height][length] = true;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int x = node[1];
            int y = node[0];
            //上下左右符合条件的加进队列
            if(y - 1 >= 0 && !isVisited[y - 1][x] && grid[y - 1][x] == '1'){
                int[] next = new int[2];
                next[0] = y - 1;
                next[1] = x;
                q.offer(next);
                isVisited[y - 1][x] = true; //更新isVis
            }
            if(y + 1 <= grid.length - 1 && !isVisited[y + 1][x] && grid[y + 1][x] == '1'){
                int[] next = new int[2];
                next[0] = y + 1;
                next[1] = x;
                q.offer(next);
                isVisited[y + 1][x] = true;
            }
            if(x - 1 >= 0 && !isVisited[y][x - 1] && grid[y][x - 1] == '1'){
                int[] next = new int[2];
                next[0] = y;
                next[1] = x - 1;
                q.offer(next);
                isVisited[y][x - 1] = true;
            }
            if(x + 1 <= grid[0].length - 1 && !isVisited[y][x + 1] && grid[y][x + 1] == '1'){
                int[] next = new int[2];
                next[0] = y;
                next[1] = x + 1;
                q.offer(next);
                isVisited[y][x + 1] = true;
            }
        }
    }


    //uf
    //Time complexity : O(M × N) where M is the number of rows and N is the number of columns. Note that Union operation takes essentially constant time when UnionFind is implemented with both path compression and union by rank.
    //Space complexity : O(M × N) as required by UnionFind data structure.
    public class unionFind{
        int[] size;     //所在树的节点个数
        int[] id;       //父节点
        int count;      //component的个数
        //n ==> 总节点个数， count表示初始component的个数，一旦合并，就减1
        public unionFind(int n, int count){
            size = new int[n];
            id = new int[n];
            for(int i = 0; i < n; i++){
                size[i] = 1;     //初始化每个节点都自己是一颗树，只有一个节点，自己本身为根节点
                id[i] = i;      //初始化根节点为自身
            }
            this.count = count;
        }
        public int getCount(){
            return count;
        }
        public int root(int i){
            while(i != id[i]){      //没到根节点的话
                id[i] = id[id[i]];  //路径压缩，将每个路径上的节点指向其路径上的祖父节点，使爬树更快
                i = id[i];
            }
            return i;
        }
        public boolean find(int i, int j) {
            return root(i) == root(j);
        }
        public void union(int i, int j){
            int ir = root(i);
            int jr = root(j);
            if(ir == jr){
                return;
            }
            //j 连到 i 上
            //根与根之间连接
            if(size[ir] >= size[jr]){
                id[ir] = jr;
                size[ir] += size[jr];
            }
            else{
                id[jr] = ir;
                size[jr] += size[ir];
            }
            count--;
        }
    }
    public int numIslands_3(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int c = 0;
        int length = grid[0].length;
        int height = grid.length;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < length; j++){
                if(grid[i][j] == '1'){
                    c++;
                }
            }
        }
        unionFind uf = new unionFind(length * height, c);
        for(int i = 0; i < height; i++){
            for(int j = 0; j < length; j++){
                //上下左右union
                if(i - 1 >= 0 && grid[i][j] == '1' && grid[i - 1][j] == '1'){
                    uf.union(i * length + j, (i - 1) * length + j);
                }
                if(i + 1 <= height - 1 && grid[i][j] == '1' && grid[i + 1][j] == '1'){
                    uf.union(i * length + j, (i + 1) * length + j);
                }
                if(j - 1 >= 0 && grid[i][j] == '1' && grid[i][j - 1] == '1'){
                    uf.union(i * length + j, i * length + j - 1);
                }
                if(j + 1 <= length - 1 && grid[i][j] == '1' && grid[i][j + 1] == '1'){
                    uf.union(i * length + j, i * length + j + 1);
                }
            }
        }
        return uf.getCount();       //看有多少个component
    }

    public static void main(String[] args){
        Number_of_Islands_200_very_very_important a =  new Number_of_Islands_200_very_very_important();
        char[][] grid = {{'1','1','1','1','1','1','1'},{'0','0','0','0','0','0','1'},{'1','1','1','1','1','0','1'},{'1','0','0','0','1','0','1'},{'1','0','1','0','1','0','1'},{'1','0','1','1','1','0','1'},{'1','1','1','1','1','1','1'}};
        System.out.println(a.numIslands_3(grid));
    }
}
