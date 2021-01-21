public class Reverse_Pairs_493_need_understand_very_important {
    //Divide and Conquer (like mergeSort)
    //时间复杂度: O(nlogn), n为nums的长度
    //空间复杂度：O(n)
    public int reversePairs(int[] nums) {
        int length = nums.length;
        return mergeSort(nums, 0 , length - 1);
    }
    private int mergeSort(int[] nums, int lo, int hi){
        int result = 0;
        if(lo >= hi){
            return result;
        }
        int mid = lo + (hi - lo) / 2;
        result += mergeSort(nums, lo, mid);     //左半部分单独的对数
        result += mergeSort(nums, mid + 1, hi);     //有半部分单独的对数
        result += merge(nums, lo, mid, hi);         //合并之后的对数
        return result;
    }
    private int merge(int[] nums, int lo, int mid, int hi){
        int result = 0;
        int p = lo;
        int q = mid + 1;
        //由于前半部分和后半部分已经有序，所以使用双指针进行探索
        while(p <= mid && q <= hi){
            //如果p指向的前半部分的数已经比nums[q]的两倍还大了，意味着p后面的数都符合条件(有序)
            if(nums[p] > 2 * (long)nums[q]){
                result += mid - p + 1;      //计算答案
                q++;                    //将后半部分的指针向后移
            }
            //否则,前半部分的指针向后移，前半部分太小
            else{
                p++;
            }
        }
        //恢复指针，将两部分进行mergeSort,使整个合并的部分有序
        p = lo;
        q = mid + 1;
        int[] aux = new int[hi - lo + 1];
        int pointer = 0;
        while(p <= mid && q <= hi){
            if(nums[p] > nums[q]){
                aux[pointer] = nums[q];
                pointer++;
                q++;
            }
            else{
                aux[pointer] = nums[p];
                pointer++;
                p++;
            }
        }
        while(p <= mid){
            aux[pointer] = nums[p];
            p++;
            pointer++;
        }
        while(q <= hi){
            aux[pointer] = nums[q];
            q++;
            pointer++;
        }
        for(int i = lo; i <= hi; i++){
            nums[i] = aux[i - lo];
        }
        return result;
    }
}
