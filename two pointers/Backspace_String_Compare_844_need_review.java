import java.util.Stack;

public class Backspace_String_Compare_844_need_review {
    //stack
    //时间复杂度：O(S.length + T.length)
    //空间复杂度：O(S.length + T.length)
    public boolean backspaceCompare(String S, String T) {
        //比较转化过后的字符串是否相同
        return transfer(S).equals(transfer(T));
    }
    //使用stack将s转化(去掉#之类的操作)
    public String transfer(String s){
        String str = "";
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            //不遇到#就进栈
            if(c!= '#'){
                stack.push(c);
            }
            //遇到#就弹出栈
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        //根据栈的内容生成结果
        while(!stack.isEmpty()){
            str = stack.pop() + str;
        }
        return str;
    }


    //two pointers
    //https://www.cnblogs.com/grandyang/p/10447783.html
    //时间复杂度：O(S.length + T.length)
    //空间复杂度：O(1)
    //倒序遍历（减低难度，因为#是删除后面的有效字母）
    public boolean backspaceCompare_2(String S, String T) {
        int p1 = S.length() - 1;    //S的指针
        int p2 = T.length() - 1;    //T的指针
        int s1 = 0;     //记录S出现的#数量
        int s2 = 0;     //记录T出现的#数量
        //此处是或，因为可能有一个字符串被遍历完
        while(p1 >= 0 || p2 >= 0){
            while(p1 >= 0){
                //遇到#时s1数量增加
                if(S.charAt(p1) == '#'){
                    s1++;
                    p1--;
                }
                //再遇到字母时，s1减少，因为可以跳过
                else if(s1 > 0){
                    s1--;
                    p1--;
                }
                else{
                    break;
                }
            }
            while(p2 >= 0){
                if(T.charAt(p2) == '#'){
                    s2++;
                    p2--;
                }
                else if(s2 > 0){
                    s2--;
                    p2--;
                }
                else{
                    break;
                }
            }
            //都处理完（过滤掉遇见的#）后，比较当前指针是否指向的字母相同
            if(p1 >= 0 && p2 >= 0 && S.charAt(p1) != T.charAt(p2)){
                return false;
            }
            //如果有一个字符串被遍历完而另一个没有被遍历完，就返回false
            if(p1 < 0 && p2 >= 0 || p2 < 0 && p1 >= 0 ){
                return false;
            }
            //遍历指针继续遍历
            p1--;
            p2--;
        }
        //之前一直没返回false,就是true
        return true;
    }
}
