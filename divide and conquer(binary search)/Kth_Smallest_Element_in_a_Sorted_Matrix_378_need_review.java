import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_Smallest_Element_in_a_Sorted_Matrix_378_need_review {
    //利用最大堆的性质
    //当堆的元素等于K时，检查新加入的元素是否比堆内的根元素小，小的话用新元素替代原来的根元素（先poll,再加入新元素）
    //时间复杂度： 建堆：O(K), 插入与poll => O(N log K), N为元素个数
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer l1, Integer l2){
                return l2 - l1;
            }
        });
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(maxPQ.size() < k){
                    maxPQ.add(matrix[i][j]);
                }
                else{
                    if(maxPQ.peek() > matrix[i][j]){
                        maxPQ.poll();
                        maxPQ.add(matrix[i][j]);
                    }
                }
            }
        }
        return maxPQ.peek();
    }
}
