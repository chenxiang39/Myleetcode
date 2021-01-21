import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation_150_need_review {
    //使用堆栈保存结果，遇到符号就计算顶部两个数字并pop掉，将结果再push进栈中
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else if(tokens[i].equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            }
            else if(tokens[i].equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if(tokens[i].equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            }
            else if(tokens[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
        }
        return stack.peek();
    }
}
