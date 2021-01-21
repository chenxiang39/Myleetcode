public class Construct_Quad_Tree_427_need_understand {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };
    //https://www.cnblogs.com/xiaochuan94/p/10236917.html
    //dfs构造
    //题目给的参数是一个二维数组，可以将其想象为一个N×N的格子，其索引就是对应位置的坐标，只要从根节点开始，遇到和根节点值不一样的坐标，
    //就需要进行等分操作，也就是从一个新的N/2×N/2格子开始，再从根节点开始判断。
    //因此可以借助递归的方法，只需要两个从0开始的索引，以及二维数组的长度即可（此参数做再分用）。
    public Node construct(int[][] grid) {
        return dfs(0,0,grid.length,grid);
    }
    private Node dfs(int x, int y, int length, int[][] grid){
        //只剩下一个就回溯
        if(length == 1){
            return new Node(grid[x][y] == 1,true);
        }
        Node result = new Node(grid[x][y] == 1,true);
        for(int i = x; i < x + length; i++){
            for(int j = y; j < y + length; j++){
                if(grid[i][j] != grid[x][y]){
                    result = new Node(grid[i][j] == 1,false);
                    result.topLeft = dfs(x,y,length/2,grid);
                    result.topRight = dfs(x,y + length/2,length/2,grid);
                    result.bottomLeft = dfs(x + length/2,y,length/2,grid);
                    result.bottomRight = dfs(x + length/2,y + length/2,length/2,grid);
                    return result;      //需要直接return 否则会超时，因为一旦遇到不同的就立刻划分，不需要等到循环结束
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Construct_Quad_Tree_427_need_understand a = new Construct_Quad_Tree_427_need_understand();
        int[][] grids = {{0,1},{1,0}};
        System.out.println(a.construct(grids));
    }
}
