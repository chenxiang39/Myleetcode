public class Longest_Mountain_in_Array_845_need_review {
    //two pointers
    //时间复杂度：O(N),N = arr.length
    //空间复杂度：O(1)
    public int longestMountain(int[] arr) {
        int result = 0;
        if(arr.length < 3){
            return result;
        }
        int left = 0;
        int right = 1;
        //是否之前是上坡
        boolean Rise = false;
        while(right < arr.length){
            //爬坡
            while(right < arr.length){
                if(arr[right - 1] < arr[right]){
                    right++;
                    Rise = true;
                }
                else{
                    break;
                }
            }
            //找到向上的斜坡
            if(Rise){
                //返回峰顶
                right--;
                //符合条件，查找下降
                while(right < arr.length - 1){
                    //符合下坡
                    if(arr[right + 1] < arr[right]){
                        //记录答案
                        result = Math.max(result, right + 1 - left + 1);
                        right++;
                    }
                    //下坡爬完，结束循环
                    else{
                        break;
                    }
                }
                //不符合条件，峰顶下降不符合下降或者已经查找完整个山峰，进入下一个查找序列
                left = right;
                right++;
                Rise = false;
            }
            //完全没有上坡，重新进入下一个循环比对
            else{
                left++;
                right++;
            }
        }
        return result;
    }
}
