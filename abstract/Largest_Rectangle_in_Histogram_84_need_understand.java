import java.util.Stack;

public class Largest_Rectangle_in_Histogram_84_need_understand {
    //brute force
    //Time complexity: O(n^2)
    //Space complexity: O(1)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int result = 0;
        //for every bar, search the max area that it can include
        for(int i = 0; i < n; i++){
            //left search(not include itself)
            int pointer = i;
            int area = 0;
            while(pointer > 0){
                if(pointer > 0 && heights[pointer - 1] < heights[i]){
                    break;
                }
                pointer--;
            }
            area += heights[i] * (i - pointer);

            //right search(not include itself)
            pointer = i;
            while(pointer < n - 1){
                if(pointer < n - 1 && heights[pointer + 1] < heights[i]){
                    break;
                }
                pointer++;
            }
            area += heights[i] * (pointer - i);
            //itself
            area += heights[i];
            result = Math.max(result, area);
        }
        return result;
    }

    //use stack
    //n : the length of height
    //Time complexity:O(n)
    //Space complexity:O(n),stack
    public int largestRectangleArea_2(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;
        for(int i = 0; i < n; i++){
            while(stack.peek()!= -1 && heights[stack.peek()] > heights[i]){
                //计算前一个柱子所能组成的面积
                int curarea = heights[stack.pop()] * (i - stack.peek() - 1);    //i - 1到stack.peek()之间的柱子满足高度大于等于heights[stack.pop()]，因此能组成长方形
                result = Math.max(result, curarea);
            }
            stack.push(i);
        }
        //剩下的柱子
        while(stack.peek() != -1){
            int curarea = heights[stack.pop()] * (n - stack.peek() - 1);
            result = Math.max(result, curarea);
        }
        return result;
    }
}
