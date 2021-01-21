import java.util.Stack;

public class Maximal_Rectangle_85_need_understand {
    //dp, stack
    //leetcode soluation 3
    //n : 高度， m:宽度
    //Time complexity : O(nm)
    //Space complexity: O(m),dp array
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int result = 0;
        //存储每一行的高度，然后将题目转化成leetcode第84题
        int dp[] = new int[matrix[0].length];
        //遍历每一行然后得出答案
        for(int i = 0;i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    dp[j] = 0;          //遇到0则清0
                }
                else{
                    dp[j]++;        //遇到1则高度增加
                }
            }
            result = Math.max(result,singleRowArea(dp));
        }
        return result;
    }
    //leetcode 84
    public int singleRowArea(int[] heights){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int j = 0; j < heights.length; j++){
            while(stack.peek()!= -1 && heights[stack.peek()] > heights[j]){
                int curarea = heights[stack.pop()] * (j - 1 - stack.peek());
                result = Math.max(result, curarea);
            }
            stack.push(j);
        }
        while(stack.peek() != -1){
            int curarea = heights[stack.pop()] * (heights.length - 1 - stack.peek());
            result = Math.max(result,curarea);
        }
        return result;
    }

}
