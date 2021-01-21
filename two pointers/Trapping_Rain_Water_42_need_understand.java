public class Trapping_Rain_Water_42_need_understand {
    //Time complexity: O(n * max), n is the length of height, max is the highest bar in height
    //Space complexity: O(1)
    public int trap(int[] height) {
        int max = 0;
        for(int h : height){
            if(max < h){
                max = h;
            }
        }
        int length = height.length;
        int canNotTrapWaterArea = 0;
        for(int h = 1; h <= max; h++){
            //calculate the area that water can not trap
            canNotTrapWaterArea = calculateCanNotTrapWaterArea(height, h, canNotTrapWaterArea);
        }
        int totalSpace = length * max;
        //minus bars' space
        for(int i = 0; i < length; i++){
            totalSpace -= height[i];
        }
        return totalSpace - canNotTrapWaterArea;
    }

    public int calculateCanNotTrapWaterArea(int[] height, int h,int canNotTrapWaterArea){
        int length = height.length;
        int start = 0;
        int end = length - 1;
        //pointer meet that this height >= h
        //stop and calculate space
        //two pointers
        while(height[start] < h){
            start++;
        }
        canNotTrapWaterArea += start * 1;
        while(height[end] < h){
            end--;
        }
        canNotTrapWaterArea += (length - 1 - end) * 1;
        return canNotTrapWaterArea;
    }

    //https://www.bilibili.com/video/BV17h411d7F6
    //two pointers
    //time complexity: O(n), n is the length of height
    //space complexity: O(1)
    public int trap_2(int[] height) {
        int max = 0;
        int max_index = 0;  //highest bar's index
        for(int i = 0; i < height.length; i++){
            if(height[i] > max){
                max = height[i];
                max_index = i;
            }
        }
        int result = 0;
        int leftpointer = 0;
        int leftlowbound = 0;
        while(leftpointer < max_index){
            //update leftlowbound
            if(leftlowbound <= height[leftpointer]){
                leftlowbound = height[leftpointer];
            }
            //meet space can store water(left and right side all have bar higher than this bar)
            else{
                result += leftlowbound - height[leftpointer];
            }
            leftpointer ++;
        }
        //two directions(two sides scan to the highest bar)
        int rightpointer = height.length - 1;
        int rightlowbound = 0;
        while(rightpointer > max_index){
            if(rightlowbound <= height[rightpointer]){
                rightlowbound = height[rightpointer];
            }
            else{
                result += rightlowbound - height[rightpointer];
            }
            rightpointer --;
        }
        return result;
    }
}
