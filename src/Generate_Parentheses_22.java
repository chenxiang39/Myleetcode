import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Generate_Parentheses_22 {
    //use StringBuilder
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result,0,0,n,new StringBuilder());
        return result;
    }

    private static void dfs(List<String> result,int left, int right, int n, StringBuilder cur){
        if (cur.length() == 2 * n){
            result.add(cur.toString());
            return;
        }

        if (left < n){
            cur.append('(');
            dfs (result,left + 1, right,n,cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left){
            cur.append(')');
            dfs (result,left, right + 1,n,cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    //use String
    public static List<String> generateParenthesis_2(int n) {
        List<String> ans = new ArrayList();
        dfs_2(ans, "", 0, 0, n);
        return ans;
    }

    public static void dfs_2(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            dfs_2(ans, cur+"(", open+1, close, max);
        if (close < open)
            dfs_2(ans, cur+")", open, close+1, max);
    }
    public static void main(String[] args){
        System.out.println(generateParenthesis(3));
    }
}
