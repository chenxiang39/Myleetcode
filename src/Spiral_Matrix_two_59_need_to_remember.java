public class Spiral_Matrix_two_59_need_to_remember {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 1;
        int loop = 0;
        for(int i = n - 1; i >=1; i--){
            for(int right = loop; right < i; right++){      //第0圈向右走 n - 1步
                result[loop][right] = start;
                start++;
            }
            for(int down = loop; down < i; down++){         //第0圈向下走 n - 1步
                result[down][n - 1 - loop] = start;
                start++;
            }
            for(int left = i ; left > loop; left--){        //第0圈向左走 n - 1步
                result[n - 1 - loop][left] = start;
                start++;
            }
            for(int up = i ; up > loop; up--){             //第0圈向上走 n - 1步
                result[up][loop] = start;
                start++;
            }
            loop++;
        }
        //如果最后四个方向汇聚到一起的话，则会出现特殊情况，直接赋值到中间（若只进行上述循环就得出结果的话，start最后的结果是 n * n + 1）
        if(start == n * n){
            result[(n+1) /2 ][(n+1) /2] = start;
        }
        return result;
    }
    public static void main(String[] args){
//        int[][] matrix = {              //matrix[0][1] = 2;
//                {1, 2, 3,4},
//                {5, 6,7,8},
//                {9, 10, 11,12}
//        };
        int n = 1;
        int[][] matrix = generateMatrix(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
}
