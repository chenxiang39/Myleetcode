import java.util.*;

//bfs
//https://www.cnblogs.com/grandyang/p/4944875.html
//把给定字符串排入队中，然后取出检测其是否合法，若合法直接返回，不合法的话，对其进行遍历，对于遇到的左右括号的字符，去掉括号字符生成一个新的字符串，如果这个字符串之前没有遇到过，
// 将其排入队中，用 HashSet 记录一个字符串是否出现过。对队列中的每个元素都进行相同的操作，直到队列为空还没找到合法的字符串的话，那就返回空集
public class Remove_Invalid_Parentheses_301_need_review {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        boolean isGet = false;
        Set<String> visited = new HashSet<>();  //是否之前已经访问过的字符串，排除重复添加
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                //符合条件的直接加入result
                if(isPar(cur)){
                    res.add(cur);
                    isGet = true;
                }
                //bfs查找最短路径的标记，因为此时找到的符合标准的字符串，一定是remove字符最少的字符串，就不需要加新元素进队列了（不需要寻找下一层）
                if(isGet){
                    continue;
                }
                //每个可以移除的括号都进行尝试
                for(int j = 0; j < cur.length(); j++){
                    //遇到其他字符
                    if(cur.charAt(j) != '(' && cur.charAt(j) != ')'){
                        continue;
                    }
                    String str = cur.substring(0,j) + cur.substring(j + 1);
                    if(!visited.contains(str)){
                        q.offer(str);
                        visited.add(str);
                    }
                }
            }
        }
        return res;
    }
    public boolean isPar(String s){
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push('(');
            }
            else if(c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
