public class Container_With_Most_Water_11 {
    //Brute force
    //Time complexity: O(n^2), Calculating area for all n * (n - 1)/2 height pairs
    //Space complexity: O(1), Constant extra space is used.
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int start = 0; start < height.length; start++){
            for (int end = start + 1; end < height.length; end++){
                if (maxArea < Math.min(height[start],height[end]) * (end - start)){
                    maxArea = Math.min(height[start],height[end]) * (end - start);      //面积等于短的一侧的高度 * 底部的长度
                }
            }
        }
        return maxArea;
    }
    //Two Pointer Approach
    //Time complexity : O(n). Single pass.
    //Space complexity : O(1). Constant space is used.
    public static int maxArea_2(int[] height) {
        int maxArea = 0;
        int length = height.length;
        int start = 0;      //左指针
        int end = length - 1;       //右指针
        while (end > start){
            if (Math.min(height[start],height[end]) * (end - start) > maxArea){
                maxArea = Math.min(height[start],height[end]) * (end - start);
            }
            if (height[end] > height[start]){       //小的指针向中间靠拢搜索
                start++;
            }
            else {
                end--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea_2(height));
    }
}
