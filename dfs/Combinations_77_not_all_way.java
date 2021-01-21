import java.util.ArrayList;
import java.util.List;

//dfs
public class Combinations_77_not_all_way {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(result, n, k, cur,1);
        return result;
    }
    private static void dfs(List<List<Integer>> result, int n,int k,List<Integer> cur,int start){
       if (cur.size() == k){
           result.add(new ArrayList(cur));      //写法见40题
           return;
       }
       for(int i = start; i <= n; i++){
           cur.add(i);
           dfs(result,n,k,cur,i + 1);       //start从i之后开始遍历
           cur.remove(cur.size() - 1);      //还原
       }
    }
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
