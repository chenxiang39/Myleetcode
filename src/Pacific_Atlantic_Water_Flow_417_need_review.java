import java.util.ArrayList;
import java.util.List;

public class Pacific_Atlantic_Water_Flow_417_need_review {
    //dfs
    //https://www.cnblogs.com/grandyang/p/5962508.html
    //那么我们就把所有边缘点当作起点开始遍历搜索，然后标记能到达的点为 true，分别标记出 pacific 和 atlantic 能到达的点，那么最终能返回的点就是二者均为 true 的点
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int w = matrix.length;
        if(w == 0){
            return result;
        }
        int l = matrix[0].length;
        List<List<Integer>> PacP = new ArrayList<>();       //pacific能到达的点
        List<List<Integer>> AtlP = new ArrayList<>();       //atlantic能到达的点
        //顶上和左边运行dfs并计算PacP
        for(int i = 0; i < l;i++){
            dfsPac(PacP,matrix, i, 0);
        }
        for(int i = 0; i < w; i++){
            dfsPac(PacP,matrix, 0, i);
        }
        //底部和右边运行dfs并计算AtlP
        for(int i = w - 1; i >= 0; i--){
            dfsAtl(AtlP,matrix, l - 1, i);
        }
        for(int i = l - 1; i >= 0; i--){
            dfsAtl(AtlP,matrix, i, w - 1);
        }
        for(List<Integer> pairs : PacP){
            if(AtlP.contains(pairs)){
                result.add(pairs);
            }
        }
        return result;
    }

    public void dfsPac(List<List<Integer>> PacP, int[][] matrix, int x, int y){
        int l = matrix[0].length;
        int w = matrix.length;
        //记录位置
        ArrayList<Integer> position = new ArrayList<>();
        position.add(y);
        position.add(x);
        //已经记录过位置的就忽略
        if(!PacP.contains(position)){
            PacP.add(position);
            //右
            if(x + 1 < l && matrix[y][x] <= matrix[y][x + 1]){
                dfsPac(PacP, matrix, x + 1, y);
            }

            //下
            if(y + 1 < w && matrix[y][x] <= matrix[y + 1][x]){
                dfsPac(PacP, matrix, x, y + 1);
            }
            //左
            if(x - 1 >= 0 && matrix[y][x] <= matrix[y][x - 1]){
                dfsPac(PacP, matrix, x - 1, y);
            }

            //上
            if(y - 1 >= 0 && matrix[y][x] <= matrix[y - 1][x]){
                dfsPac(PacP, matrix, x, y - 1);
            }
        }
    }

    public void dfsAtl(List<List<Integer>> AtlP, int[][] matrix, int x, int y){
        int l = matrix[0].length;
        int w = matrix.length;
        ArrayList<Integer> position = new ArrayList<>();
        position.add(y);
        position.add(x);
        if(!AtlP.contains(position)){
            AtlP.add(position);
            //左
            if(x - 1 >= 0 && matrix[y][x] <= matrix[y][x - 1]){
                dfsAtl(AtlP, matrix, x - 1, y);
            }

            //上
            if(y - 1 >= 0 && matrix[y][x] <= matrix[y - 1][x]){
                dfsAtl(AtlP, matrix, x, y - 1);
            }
            //右
            if(x + 1 < l && matrix[y][x] <= matrix[y][x + 1]){
                dfsAtl(AtlP, matrix, x + 1, y);
            }

            //下
            if(y + 1 < w && matrix[y][x] <= matrix[y + 1][x]){
                dfsAtl(AtlP, matrix, x, y + 1);
            }
        }
    }

}
