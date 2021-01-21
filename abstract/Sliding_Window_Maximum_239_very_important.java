import java.util.ArrayDeque;
import java.util.Deque;


//https://segmentfault.com/a/1190000003903509
//https://www.bilibili.com/video/BV1t4411c7km?from=search&seid=1028298811441307675
public class Sliding_Window_Maximum_239_very_important {
    //brute force
    //Time complexity : O(nums.length * k);
    //Space complexity : O(nums.length);
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i <= nums.length - k; i++){
            int max = nums[i];
            for(int j = i + 1; j < i + k; j++){
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }


    // Use Deque
    // Time complexity : O(nums.length);
    // since each element is processed exactly twice - it's index added and then removed from the deque.
    // Space complexity: O(nums.length);   O(N - k + 1) => result, O(k) ==> Deque
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();         //new data structure, https://blog.csdn.net/ted_cs/article/details/82926423
        //Elements in a deque always have the largest head node
        for(int i = 0; i < nums.length; i++){
            //if the biggest number is the leftmost index, delete it
            if(!dq.isEmpty() && dq.peekFirst() == i - k){
                dq.pollFirst();
            }
            // Remove all from last when their values are less than current value, as they cannot be maximum in the current window
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            //add new element
            dq.offerLast(i);
            //firstNode is the biggest node
            if(i >= k - 1){
                result[i - (k - 1)] = nums[dq.peekFirst()];
            }
        }
        return result;
    }

    //dp
    //Time complexity: O(nums.length), since all we do is 3 passes along the array of length
    //Sapce complexity: O(nums.length),  keep left and right arrays of nums.length , and output array of length nums.length - k + 1;
    public int[] maxSlidingWindow_3(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length - k + 1];

        //structure left and right array

        //in every k area, the elements in left array is ascending order
        int leftmax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(i % k == 0){
                leftmax = nums[i];
                left[i] = leftmax;
            }
            else{
                leftmax = Math.max(nums[i], leftmax);
                left[i] = leftmax;
            }
        }
        //in every k area, the elements in right array is descending order
        int rightmax = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i == nums.length - 1 || (i + 1) %  k == 0){
                rightmax = nums[i];
                right[i] = rightmax;
            }
            else{
                rightmax = Math.max(nums[i], rightmax);
                right[i] = rightmax;
            }
        }

        for(int i = 0; i < nums.length - k + 1; i++){
            result[i] = Math.max(left[i + k - 1], right[i]);
        }
        return result;
    }
}
