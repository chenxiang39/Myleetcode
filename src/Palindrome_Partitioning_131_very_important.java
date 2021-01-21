import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_131_very_important {
    //dfs
    //这里想法是，用递归循环找子问题的方法，把母串按所有组合可能性拆分，如果是回文，就加进来，当层数为s的length时就有一个结果了。
    //这里需要判断是否为回文
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s.isEmpty()){
            return result;
        }
        List<String> cur = new ArrayList<>();
        dfs(result, cur, s, 0);
        return result;
    }
    public static void dfs(List<List<String>> result, List<String> cur, String s, int start){
        //遍历完所有的字符后加入结果
        if(start == s.length()){
            result.add(new ArrayList(cur));
            return;
        }
        //遍历截取字符串并进行回文确认
        for(int i = start; i < s.length(); i++){
            String st = s.substring(start, i + 1);      //https://www.runoob.com/java/java-string-substring.html
            if(isPalindrome(st)){
                cur.add(st);            //是回文的进入cur
                dfs(result, cur, s, i + 1);     //从截掉的后面开始遍历
                cur.remove(cur.size() - 1);     //回溯
            }
        }
    }
    private static boolean isPalindrome(String s){
        if(s.length() == 0){
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        while(end > start){
            if(s.charAt(end) != s.charAt(start)){
                return false;
            }
            end--;
            start++;
        }
        return true;
    }
    public static void main(String[] args){
        String s = "aab";
        System.out.println(partition(s));
//        System.out.println(s.substring(1,2));
    }
}
