public class Rotate_Image_48_need_to_exercise {
    public static void rotate(int[][] matrix) {
        //转置(斜对角交换)
        for(int i=0;i< matrix.length;i++)
        {
            for(int j = i;j < matrix.length;j++)        //注意，从i开始
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //反转每一行
        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = {              //matrix[0][1] = 2;
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        System.out.println(matrix);
    }
}
