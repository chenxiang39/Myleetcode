import java.util.HashSet;
import java.util.Set;

public class Set_Matrix_Zeroes_73_need_to_remember {
    //brute force
    //Time Complexity: O(M×N) where M and N are the number of rows and columns respectively.
    //Space Complexity: O(M + N) (Set)
    public void setZeroes(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //保存0的点的位置
                if (matrix[i][j] == 0){
                    col.add(j);
                    row.add(i);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //只要有一个行或者一个列中出现0，则将元素设置成0
                if (col.contains(j) || row.contains(i)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    //Approach 3: O(1) Space, Efficient Solution（leetcode 方法3)
    //Time Complexity : O(M×N)
    //Space Complexity : O(1)
    public void setZeroes_2(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        boolean isCol = false;      //第一列是否全部变成0
        boolean isRow = false;      //第一行是否全部变成0
        for (int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                isCol = true;
            }
        }
        for (int i = 0; i < n; i++){
            if(matrix[0][i] == 0){
                isRow = true;
            }
        }
        //找到0后，改变其映射到第一行和第一列，使其变0
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //一旦遇到其映射在第一行或第一列的位置为0，则将其设置为0
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(isCol){
            for (int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        if(isRow){
            for (int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }
    }
}
