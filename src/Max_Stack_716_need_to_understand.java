import java.util.Stack;

//思路与155不同，使用双栈
//Time Complexity: O(N) for the popMax operation, and O(1) for the other operations, where N is the number of operations performed.
//Space Complexity: O(N), the maximum size of the stack.
public class Max_Stack_716_need_to_understand {
    Stack<Integer> stack = new Stack<>();           //存当前值
    Stack<Integer> maxStack = new Stack<>();        //存当前值对应的目前的最大值
    public Max_Stack_716_need_to_understand() {

    }

    public void push(int x) {
        stack.push(x);
        if(maxStack.size() == 0){
            maxStack.push(x);
        }
        else{
            int max = x > maxStack.peek() ? x : maxStack.peek();
            maxStack.push(max);
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> aux = new Stack<>();     //把max上面的内容暂时存起来
        while(top() != max){
            aux.push(pop());
        }
        pop();                  //删除max
        while(!aux.isEmpty()){
            push(aux.pop());            //放回去

        }
        return max;
    }
    public static void main(String[] args){
        Max_Stack_716_need_to_understand stack = new Max_Stack_716_need_to_understand();
        stack.push(79);
        System.out.println(stack.pop());
        stack.push(14);
        stack.push(67);
        stack.push(19);
        stack.push(-92);
        System.out.println(stack.popMax());
        stack.push(77);
        System.out.println(stack.pop());
        stack.push(53);
        stack.push(5);
        System.out.println(stack.peekMax());
        System.out.println(stack.popMax());
        stack.push(12);
    }
}
