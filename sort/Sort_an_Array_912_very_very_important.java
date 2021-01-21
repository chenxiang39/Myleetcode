//空间复杂度解释：https://blog.csdn.net/taotao12312/article/details/69664351
public class Sort_an_Array_912_very_very_important {
    //Mergesort
    //Time complexity: O(NlogN), N ==> length of nums
    //Space complexity: O(N + logN) ==> O(N)
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int left , int right){
        if(left == right){
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left , mid);
        sort(nums, mid + 1, right);
        merge(nums, left, right);
    }

    public void merge(int[] nums, int left , int right){
        int[] result = new int[right - left + 1];
        int mid = left + (right - left) / 2;
        int lp = left;
        int rp = mid + 1;
        int p = 0;
        while(lp <= mid && rp <= right){
            if(nums[lp] < nums[rp]){
                result[p] = nums[lp];
                lp++;
                p++;
            }
            else{
                result[p] = nums[rp];
                rp++;
                p++;
            }
        }
        //if still have some elements not be comapred
        while(lp <= mid){
            result[p] = nums[lp];
            lp++;
            p++;
        }
        while(rp <= right){
            result[p] = nums[rp];
            rp++;
            p++;
        }

        for(int i = 0; i < right - left + 1; i++){
            nums[i + left] = result[i];
        }
    }

    //Quicksort
    //Time complexity: O(NlogN), N ==> length of nums
    //Space complexity: O(logN), 递归栈的深度
    public int[] sortArray_2(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort_2(int[] nums, int start, int end){
        //if start < j - 1
        if(start >= end){
            return;
        }

        int pivot = nums[start];
        int i = start + 1;
        int j = end;
        //make sure that when finish loop, i != j
        while(i <= j){
            if(nums[i] < pivot){
                i++;
                continue;
            }
            if(nums[j] >= pivot){
                j--;
                continue;
            }
            //nums[i] >= pivot && nums[j] < pivot
            swap(nums, i, j);
        }
        //swap with start and j
        swap(nums, start, j);
        sort_2(nums, start, j - 1);
        sort_2(nums, j + 1, end);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
