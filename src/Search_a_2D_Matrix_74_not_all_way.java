public class Search_a_2D_Matrix_74_not_all_way {
    //Binary Search
    //时间复杂度：O(log2(M) + log2(N)),这里的M和N代表矩阵的行和列
    public static boolean searchMatrix(int[][] matrix, int target) {
        //特殊情况！！！！！！！
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rowPos = 0;
        int lo = 0;
        int hi = matrix.length - 1;     //左闭右闭
        int mid = 0;
        //先找出所在的列
        while(lo <= hi){        //注意等号！因为左闭右闭
            mid = lo + (hi - lo)/2;
            if (matrix[mid][0] == target){
                return true;
            }
            if(matrix[mid][0] > target){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        rowPos = lo > 0 ? lo - 1: lo;   //先找出所在的行，若为0，则输出0，不然需要减一，因为下一行的第一个比target大
        lo = 0;
        hi = matrix[0].length - 1;
        //在行中进行binary search
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            if (matrix[rowPos][mid] == target){
                return true;
            }
            if(matrix[rowPos][mid] > target){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = {              //matrix[0][1] = 2;
                {1,   3},
        };
        System.out.println(searchMatrix(matrix,3));
    }
}
