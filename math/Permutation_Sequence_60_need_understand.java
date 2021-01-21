import java.util.ArrayList;
import java.util.List;

public class Permutation_Sequence_60_need_understand {
    //Math problem
    //https://www.bilibili.com/video/BV1Ct4y1X7tK
    //https://www.cnblogs.com/springfor/p/3896201.html
    //Time complexity: O(n^2), remove operation
    //Space complexity: O(n), factorial array, list
    public static String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i = 1; i < n; i++){
            factorial[i] = i * factorial[i - 1];
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        StringBuilder result = new StringBuilder();
        k = k - 1;
        for(int i = n - 1; i >= 0; i--){
            int ans = k / factorial[i];
            result.append(list.get(ans));
            list.remove(ans);   // ==> O(n)
            k = k % factorial[i];
        }
        return result.toString();
    }
    public static void main(String[] args){
        System.out.print(getPermutation(3,3));
    }
}
