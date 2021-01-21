import java.util.ArrayDeque;
import java.util.Deque;


public class Create_Maximum_Number_321_need_understand {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1 + l2 < k){
            return res;
        }
        for(int i = 0 ; i <= k; i++){
            if(k - i > nums2.length || i > nums1.length){
                continue;
            }
            int[] r1 = maxK(nums1,i);
            int[] r2 = maxK(nums2,k - i);
            int[] cur = merge(r1,r2);
            if(compare(cur, res)){
                res = cur;
            }
        }
        return res;
    }
    // nums1 >= nums2 ==> true
    public static boolean compare(int[] nums1,int[] nums2){
        int length = Math.min(nums1.length,nums2.length);
        for(int i = 0; i < length; i++){
            if(nums1[i] > nums2[i]){
                return true;
            }
            else if(nums1[i] == nums2[i]){
                continue;
            }
            else {
                return false;
            }
        }
        return length == nums1.length? true : false;
    }
    public static int[] merge(int[] nums1, int[] nums2){
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] res = new int[l1 + l2];
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while(p1 < l1 && p2 < l2){
            if(compare(nums1, nums2)){
                res[p3] = nums2[p2];
                p2++;
                p3++;
            }
            else {
                res[p3] = nums1[p1];
                p1++;
                p3++;
            }
        }
        while (p1 < l1){
            res[p3] = nums1[p1];
            p1++;
            p3++;
        }
        while (p2 < l2){
            res[p3] = nums2[p2];
            p2++;
            p3++;
        }
        return res;
    }
    public static int[] maxK(int[] nums, int k){
        int toPop;
        int length = nums.length;
        if(length >= k){
            toPop = length - k;
        }
        else{
            return nums;
        }
        Deque<Integer> q = new ArrayDeque();
        for(int i = 0; i < length; i++){
            while (q.size() > 0 && q.size() <= k && toPop > 0 && q.getLast() < nums[i]) {
                q.removeLast();
                toPop--;
            }
            if(q.size() < k) {
                q.offer(nums[i]);
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = q.removeFirst();
        }
        return res;
    }
    public static void main(String[] args){
        int nums1[] = {7,6,1,9,3,2,3,1,1};
        int nums2[] = {4,0,9,9,0,5,5,4,7};
        int[] r2 = maxK(nums1,6);
//        nums1 = maxNumber(nums1,nums2,9);
        for(int i : nums1){
            System.out.println(i);
        }
    }
}
