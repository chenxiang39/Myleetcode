import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Remove_Duplicate_Letters_316_need_review {
    //greedy, stack
    //总是贪婪地让栈的长度最短
    //参考leetcode solution 2，不完全一样
    //时间复杂度：O(s.length)
    //空间复杂度：O(1),stack内装的最多不超过26个字母(遇到重复的字母要么跳过要么之前删除过)，同理map也是，因此有固定界
    public String removeDuplicateLetters(String s) {
        //保存结果的栈
        Stack<Character> stack = new Stack<>();
        //key:字符, value:在s中出现的字符的频率
        Map<Character,Integer> map = new HashMap<>();
        String result = "";
        for(char c : s.toCharArray()){
            //遍历，填充map
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else{
                map.put(c, 1);
            }
        }
        for(char c : s.toCharArray()){
            //如果堆栈是空的，直接添加
            if(stack.isEmpty()){
                stack.push(c);
                //相应地，需要减少字符对应出现的次数，以此推断字符时候还会再次出现
                map.put(c, map.get(c) - 1);
            }
            else{
                //栈顶元素比当前要加入的元素大
                if(stack.peek() > c){
                    //如果之前已经加入过，不必重复加入
                    if(stack.contains(c)){
                        map.put(c, map.get(c) - 1);
                        continue;
                    }
                    //没加入过的话，可能需要删除之前存在于栈中的元素(存在于栈中的元素还会在之后出现)，因为该字符更小
                    while(!stack.isEmpty() && stack.peek() > c){
                        //如果栈中的元素之后不会再出现了（或者栈顶的元素更小），就停止pop
                        if(map.get(stack.peek()) == 0){
                            break;
                        }
                        else{
                            stack.pop();
                        }
                    }
                    //添加元素
                    stack.push(c);
                    map.put(c, map.get(c) - 1);
                }
                //遇到相同大小的元素
                else if(stack.peek() == c){
                    //直接减掉出现次数并跳过
                    map.put(c, map.get(c) - 1);
                    continue;
                }
                //栈顶元素比当前要加入的元素小
                else{
                    //如果之前没加过就加入
                    if(!stack.contains(c)){
                        stack.push(c);
                    }
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        //拼接答案
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
    }
}
