public class Search_a_2D_Matrix_II_240_need_review {
    //binary search
    //https://blog.csdn.net/huang_j_j/article/details/82560282
    //矩阵中间的元素可以将矩阵分为4份。若中间元素值比目标值小，则左上角的矩阵的值均小于目标值，而与目标值相等的元素可以出现在其他3个矩阵中；
    //若中间元素值比目标值大，则右下角的矩阵的值均大于目标值，而与目标值相等的元素可以出现在其他3个矩阵中。
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length;
        int l = matrix[0].length;
        if(h == 0){
            return false;
        }
        return bs(matrix, target, 0, h - 1, 0, l - 1);
    }

    public boolean bs(int[][] matrix, int target, int rstart, int rend, int cstart, int cend){
        //出口
        if(rstart > rend || cstart > cend){
            return false;
        }
        int rmid = rstart + (rend - rstart) / 2;
        int cmid = cstart + (cend - cstart) / 2;
        if(matrix[rmid][cmid] == target){
            return true;
        }
        //分情况讨论其他三个矩阵
        else if(matrix[rmid][cmid] > target){
            //左上角矩阵，左下角矩阵，右上角矩阵
            return bs(matrix, target, rstart, rmid - 1, cstart, cmid - 1) ||
                    bs(matrix, target, rmid, rend , cstart, cmid - 1) ||
                    bs(matrix, target, rstart, rmid - 1, cmid, cend);
        }
        else{
            //右下角矩阵，左下角矩阵，右上角矩阵
            return bs(matrix, target, rmid + 1, rend, cmid + 1, cend) ||
                    bs(matrix, target, rmid + 1, rend , cstart, cmid) ||
                    bs(matrix, target, rstart, rmid, cmid + 1, cend);
        }
    }
}
