import java.util.Stack;

public class Remove_K_Digits_402_need_review {
    //greedy, stack
    //https://www.cnblogs.com/grandyang/p/5883736.html
    //贪婪策略： 只要发现当前的数字小于栈顶元素的话，就将栈顶元素移除，比如点那个遍历到2的时候，栈里面有1和3，此时2小于栈顶元素3，那么将3移除即可。
    //这是因为此时栈顶元素在高位上，就算后面的数字再大，也是在低位上，我们只有将高位上的数字尽可能的变小，才能使整个剩下的数字尽可能的小。
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for(Character c : num.toCharArray()){
            //堆栈为空或者k已经为0了，就直接加入字符
            if(stack.isEmpty() || k == 0){
                //当栈为空且当前要加的字符是0时，停止加入
                if(stack.isEmpty() && c == '0'){
                    continue;
                }
                stack.push(c);
            }
            else{
                //发现当前的数字小于栈顶元素的话，就将栈顶元素移除，直到遇到更小的栈顶元素或者堆栈为空
                while(k > 0){
                    if(!stack.isEmpty() && c < stack.peek()){
                        stack.pop();
                        k--;
                    }
                    else{
                        break;
                    }
                }
                //为了避免出现0200的情况，当栈为空且当前要加的字符是0时，停止加入
                if(stack.isEmpty() && c == '0'){
                    continue;
                }
                stack.push(c);
            }
        }
        //为了避免出现num=1234，k=1这种情况，上面的算法不会去掉任何数字，这时直接去掉尾部的4即可
        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        //当堆栈为空时，比如num=10，k=2这种情况
        if(stack.isEmpty()){
            return "0";
        }
        //拼出答案
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
    }
}
