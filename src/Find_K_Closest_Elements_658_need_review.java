import java.util.ArrayList;
import java.util.List;

public class Find_K_Closest_Elements_658_need_review {
    //binary search
    //https://www.bilibili.com/video/BV1Px41177zS
    //https://www.cnblogs.com/grandyang/p/7519466.html
    //时间复杂度： O(log(arr.length - k))
    //空间复杂度： O(k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr[0] >= x){
            getResult(result, arr, 0, k);
        }
        else if(x >= arr[arr.length - 1]){
            getResult(result, arr, arr.length - k, k);
        }
        else{
            int lo = 0;
            int hi = arr.length - k;
            while(lo < hi){
                //1.....mid.....N
                //1....mid..|..mid + k...N
                //          ^
                //          x  ==>若此时x的位置处于mid和mid + k之间正中间位置，即到此两点距离相等，则mid是题目所求的数组的起始点
                //将mid所在位置与x的距离与mid + k与x的距离比较
                //如果此时x更偏向mid,则答案的start位置将处于1...mid
                //反之则偏向于mid.... arr.length - k, 以此实现二分查找
                int mid = lo + (hi - lo) / 2;
                if(Math.abs(x - arr[mid]) > Math.abs(arr[mid + k] - x)){
                    lo = mid  + 1;
                }
                else{
                    hi = mid;
                }
            }
            getResult(result, arr, lo, k);
        }
        return result;
    }
    //知道start位置，生成答案
    public void getResult(List<Integer> result, int[] arr, int start, int k){
        for(int i = 0; i < k; i++){
            result.add(arr[start + i]);
        }
    }
}
