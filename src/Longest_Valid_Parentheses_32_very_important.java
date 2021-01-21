import java.util.Stack;

public class Longest_Valid_Parentheses_32_very_important {
    //https://www.bilibili.com/video/BV1QK4y147Tk
    //Use stack
    //Time complexity: O(N), N = the length of s
    //Space complexity: O(N), ==> Stack
    public int longestValidParentheses(String s) {

        //((()  ==> 2
        //(            )()()()  ==> 8
        //start     record which position started when stack is empty and legal
        Stack<Integer> stack = new Stack<>();           //record Indice
        int start = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else{
                //illegal condition
                if(stack.empty()){
                    start = i + 1;          //restart count the number
                }
                else{
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, i - start + 1);
                    }
                    else{
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }

    public int longestValidParentheses_2(String s) {
        //dp
        //time complexity : O(n), n is the length of s, Single traversal of string to fill dp array is done.
        //space complexity: O(n), dp array;
        //https://www.bilibili.com/video/BV1yi4y1G74d
        //dp[i] means ===> until s[i] , the length of valid substring

        //(     )      (       )    (     )
//   dp:0 0     2      0      2+2   0    2+2+2
//                             ^
        //)     )      (       )    (     )
//   dp:0 0     0      0       2    0    2 + 2
//                             ^


        //(     )      (       (    )     )
//   dp:0 0     2      0       0    2    2+2+2
//              ^      ^            ^
        //(     )      )       (    )     )
//   dp:0 0     2      0       0    2     0
//                     ^

        //if s[i - 1] == '('
        //dp[i] = 0

        //if s[i - 1] == ')'
        //    if(s[i - dp[i - 1] - 2] == '('   can pair with s[i - 1];
        //dp[i] = 2 + dp[i - 1] + dp[i - dp[ i - 1] - 1 - 1];
        //   else dp[i] = 0;
        s = s.trim();       // Remove whitespace from both sides of a string:
        int length = s.length();
        int max = 0;
        if(length == 0 || length == 1){
            return max;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= length; i++){
            if(s.charAt(i - 1) == '('){
                dp[i] = 0;
            }
            else{
                if(s.charAt(i - 2) == '('){
                    dp[i] = 2 + dp[i - 2];
                    max = Math.max(max,dp[i]);
                }
                else{
                    if(i - dp[i - 1] - 1 > 0 && s.charAt(i - dp[i - 1] - 2) == '('){
                        dp[i] = 2 + dp[i - 1] + dp[i - dp[ i - 1] - 2];
                        max = Math.max(max,dp[i]);
                    }
                    else{
                        dp[i] = 0;
                    }
                }
            }
        }
        return max;
    }
}
