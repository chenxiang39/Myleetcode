public class Median_of_Two_Sorted_Arrays_4_very_important {
    //two pointers
    //Time complexity: O(nums1.length + nums2.length);
    //Spce complexity: O(nums1.length + nums2.length); ===> new Array
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;

        int p1 = 0;
        int p2 = 0;

        int[] newArray = new int[size];
        int pn = 0;
        //merge two array into new Array
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] < nums2[p2]){
                newArray[pn] = nums1[p1];
                p1++;
            }
            else{
                newArray[pn] = nums2[p2];
                p2++;
            }
            pn++;
        }
        //if one of Array still have number, keep insert them into new Array
        while(p1 < nums1.length){
            newArray[pn] = nums1[p1];
            p1++;
            pn++;
        }
        while(p2 < nums2.length){
            newArray[pn] = nums2[p2];
            p2++;
            pn++;
        }

        //if size is odd number
        if(size % 2 == 1){
            return newArray[size / 2];
        }
        //if size is even number
        else{
            return (double)(newArray[size / 2 - 1] + newArray[size / 2])/2;
        }
    }

    //Binary Search
    //Time complexity: O(logN), N => Math.min(nums1,length, nums2,length)
    //Space complexity: O(1)
    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        //alway let nums1 is the shorter array (use shorter array to do binary search)
        if(nums1.length > nums2.length){
            return findMedianSortedArrays_2(nums2, nums1);
        }
        int total_length = nums1.length + nums2.length;

        //corner case
        //both 0 || 0 and 1;
        if(nums1.length == 0){
            if(nums2.length != 0){
                //even length
                if(total_length % 2 == 0){
                    return (double)(nums2[total_length / 2 - 1] + nums2[total_length / 2]) / 2;
                }
                //odd length
                else{
                    return nums2[total_length / 2];
                }
            }
            else{
                return 0;
            }
        }
        //       nums2_left
        // 2, 5, 7, 8, | 11, 15  =====> nums2 (6)



        // 3, | 6, 8, 12         =====> nums1 (4)
        // #           #
        //nums1_left

        //avoid overflow
        //if mid == nums1.length,, means all nums1 element can be compose into left part
        //if mid == -1, means all nums1 can not be compose into left part
        int p1 = -1;
        int p2 = nums1.length;
        while(p1 <= p2){            //p1 == p2 == nums1.length -1 ====> corner case
            int mid = p1 + (p2 - p1) / 2;
            int p3 = total_length / 2 - mid - 1 - 1;

            //array overflow
            int nums2_left = p3 < 0 ? Integer.MIN_VALUE : nums2[p3];
            int nums2_right = p3 == nums2.length - 1? Integer.MAX_VALUE : nums2[p3 + 1];       //only happend when nums1.length == nums2.length && nums2 all elements are smaller than nums1;

            int nums1_left = mid < 0 ? Integer.MIN_VALUE : nums1[mid];
            int nums1_right = mid ==  nums1.length - 1? Integer.MAX_VALUE : nums1[mid + 1];

            if(nums2_left <= nums1_right && nums1_left <= nums2_right){
                //length is ven number => two numbers's average
                if(total_length % 2 == 0){
                    return (double) (Math.max(nums1_left, nums2_left) + Math.min(nums1_right, nums2_right)) / 2;
                }
                //length is even number => just the middle number
                else{
                    return Math.min(nums1_right, nums2_right);
                }
            }
            if(nums2_left > nums1_right){
                p1 = mid + 1;
            }
            else{
                p2 = mid - 1;
            }
        }
        return - 1;
    }

}
