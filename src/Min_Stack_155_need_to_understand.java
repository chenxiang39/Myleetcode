import java.util.Stack;

public class Min_Stack_155_need_to_understand {
    //时间复杂度：O(1),各个操作
    //空间复杂度：　O(2 * n) => O(n)，最差的结果是全部都是push操作
    Stack<int[]> stack = new Stack<>();     //栈中存储当前值以及对应的最小值
    public Min_Stack_155_need_to_understand() {

    }

    public void push(int x) {
        int[] info = new int[2];
        info[0] = x;        //当前值
        if(stack.size() == 0){
            info[1] = x;
        }
        else{
            int[] PreInfo = stack.peek();
            if(x < PreInfo[1]){
                info[1] = x;        //如果新加入的比之前的最小值小，则最小值为新加入的值
            }
            else{
                info[1] = PreInfo[1];       //否则为之前的最小值
            }
        }
        stack.push(info);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        int[] info = stack.peek();
        return info[0];
    }

    public int getMin() {
        int[] info = stack.peek();
        return info[1];
    }
}
