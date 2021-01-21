import java.util.Stack;

public class Simplify_Path_71_not_all_way_need_to_remember {
    //String字符串比较需要用equals !!!!!!!!
    //简化路径，.表示当前目录，../表示上级目录。
    // 使用一个Stack保存目录即可，遇到“”、“.”跳过；遇到“..”，若stack不为空弹出栈顶元素；遇到其他字符串直接入栈。
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] s = path.split("/");           //对path进行切割，将/去除,原来叠加/的位置会出现""的情况，直接continue
        for (int i = 0; i < s.length;i++){
            if(s[i].equals("") || s[i].equals(".")){
                continue;
            }
            if (s[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            else {
                stack.push(s[i]);
            }
        }
        String result = new String();
        int size = stack.size();
        if(size == 0){
            return "/";
        }
        for(int i = 0; i < size;i++){
            result = "/" + stack.pop() + result;    //将新出栈的东西放到后面
        }
        return result;
    }
    public static void main(String[] args){
        String a = "home//foo/3/4/5/6/7/8";
        String[] b = a.split("/",3);
//        for(String i : b){
//            System.out.println("c:" + i);
//        }
        System.out.println(b);
//        System.out.println(simplifyPath(a));
    }
}
