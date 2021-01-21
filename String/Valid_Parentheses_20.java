import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid_Parentheses_20 {
    //My way
    public static boolean isValid(String s) {
        Map< Character, Integer> chSt = new HashMap<>();
        chSt.put('(',0);
        chSt.put(')',1);
        chSt.put('{',2);
        chSt.put('}',3);
        chSt.put('[',4);
        chSt.put(']',5);
        Character[] auxchSt = {'(',')','{','}','[',']'};
        Stack<Character> ch = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                ch.push(s.charAt(i));
            }
            else if(!ch.isEmpty()){         //不空栈
                if (auxchSt[chSt.get(s.charAt(i)) - 1] == ch.peek() ){      //peek的意思是查找栈中的顶部元素,如果顶部的元素能与进入的元素匹配的话（在auxchSt中下标差1），则出栈
                    ch.pop();
                }
                else {          //不能匹配则不符合规范
                    return false;
                }
            }
            else {      //空栈时直接加不可能匹配的字符，直接不符合
                return false;
            }
        }
        return ch.isEmpty();
    }
    //other way (more faster)
    //use stack
    public static boolean isValid_2(String s) {
        Stack<Character> str = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                str.push(c);
            }
            else {
                if (!str.isEmpty() && isMatch(str.peek(),c)){       //顶部元素是否匹配
                    str.pop();
                }
                else {
                    return false;
                }
            }
        }
        return str.isEmpty();
    }
    //匹配规则，合理的左右符号则可以匹配
    private static boolean isMatch (char peek, char checkChar){
        return peek == '(' && checkChar == ')' || peek == '{' && checkChar == '}' || peek == '[' && checkChar == ']' ;
    }
    public static void main(String[] args){
        System.out.println(isValid_2("]"));
    }
}
