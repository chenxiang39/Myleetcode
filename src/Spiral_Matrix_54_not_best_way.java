import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Spiral_Matrix_54_not_best_way {
    //recursive way, not good (因为contains判断的复杂度是O(n),n为Arraylist的元素数量)
    //https://blog.csdn.net/ffghggf/article/details/87347683 => List,Set,Map解析
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();       //此处不能用Set代替，因为顺序会变
        recursive(result, matrix,0,0,0);
        return result;
    }
    private static void recursive(List<Integer> result, int[][] matrix, int direction, int curColumn, int curRow){
        //到边缘不判断的原因是因为，到了边缘，若是出现走不了的情况，则一定是已经遍历完的情况
        if (result.size() == matrix[0].length * matrix.length){
            return;
        }
        result.add(matrix[curColumn][curRow]);
        //向右方向
        if (direction == 0){
            //没到边缘
            if(curRow < matrix[0].length  - 1&& !result.contains(matrix[curColumn][curRow + 1])){
                recursive(result,matrix,0,curColumn,curRow + 1);
            }
            //到边缘(向下)（不用判断是否能向下）
            else{
                recursive(result,matrix,1,curColumn + 1,curRow);
            }
        }
        //向下方向
        if (direction == 1){
            //没到边缘
            if(curColumn < matrix.length - 1&& !result.contains(matrix[curColumn + 1][curRow])){
                recursive(result,matrix,1,curColumn + 1,curRow);
            }
            //到边缘(向左)（不用判断是否能向左）
            else{
                recursive(result,matrix,2,curColumn ,curRow - 1);
            }
        }
        //向左方向
        if (direction == 2){
            //没到边缘
            if(curRow > 0 && !result.contains(matrix[curColumn][curRow - 1])){
                recursive(result,matrix,2,curColumn,curRow - 1);
            }
            //到边缘(向上)（不用判断是否能向上）
            else{
                recursive(result,matrix,3,curColumn - 1,curRow);
            }
        }
        //向上方向
        if (direction == 3){
            //没到边缘
            if(curColumn > 0 && !result.contains(matrix[curColumn - 1][curRow])){
                recursive(result,matrix,3,curColumn - 1,curRow);
            }
            //到边缘(向右)（不用判断是否能向右）
            else{
                recursive(result,matrix,0,curColumn,curRow + 1);
            }
        }
    }
    public static void main(String[] args){
//        int[][] matrix = {              //matrix[0][1] = 2;
//                {1, 2, 3,4},
//                {5, 6,7,8},
//                {9, 10, 11,12}
//        };
        int n = 60;
        int[][] matrix = new int[n][n];
        int start = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = start;
                start++;
            }
        }
        long time = System.currentTimeMillis();
        System.out.println(spiralOrder(matrix));
        System.out.println(System.currentTimeMillis() - time);
    }
}
