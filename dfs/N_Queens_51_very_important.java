import java.util.ArrayList;
import java.util.List;

public class N_Queens_51_very_important {
    //dfs
    //Time complexity: O(!n)
    //Space complexity: O(n), 堆栈深度
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> solution = new ArrayList<>();
        dfs(result, solution,0,n);
        return result;
    }
    private void dfs(List<List<String>> result, List<String> solution, int col, int n){
        //每一行都能被放入，则是合理的solution
        if(solution.size() == n){
            result.add(new ArrayList(solution));
            return;
        }
        //这一行的每一个都去尝试
        for(int i = 0; i < n; i++){
            //符合规则就进行下一行的探索
            if(check(solution, i, col, n)){
                solution.add(createRow(i,n));
                dfs(result, solution, col + 1, n);
                solution.remove(solution.size() - 1);   //还原
            }
        }
    }
    private boolean check(List<String> solution, int row, int col, int n){
        //空的情况直接返回正确
        if(solution.size() == 0){
            return true;
        }
        int size = solution.size();
        //一列上是否有皇后（上方）
        for(int i = 0; i < size; i++){
            String rowData = solution.get(i);
            if(rowData.charAt(row) == 'Q'){
                return false;
            }
        }
        //对角线是否有皇后（上方）
        for(int i = 0; i < size; i++){
            //每一行对应的偏差值
            int offset = col - i;
            String rowData = solution.get(i);
            if(row + offset < n){
                if(rowData.charAt(row + offset) == 'Q'){
                    return false;
                }
            }
            if(row - offset >= 0){
                if(rowData.charAt(row - offset) == 'Q'){
                    return false;
                }
            }
        }
        return true;
    }

    //生成一行
    private String createRow(int i, int n) {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (j != i) {
                result.append('.');
            } else {
                result.append('Q');
            }
        }
        return result.toString();
    }
}
