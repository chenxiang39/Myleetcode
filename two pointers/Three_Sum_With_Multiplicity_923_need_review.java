import java.util.Arrays;

public class Three_Sum_With_Multiplicity_923_need_review {
    //two pointers
    //时间复杂度：O(arr.length)
    //空间复杂度：O(1)
    // 因为有很多重复的数字，所以将相同的数字放在一起便于统计，可以对数组进行排序，然后遍历数组，先确定一个数字 arr[i]，
    // 则只需要找另外两个数字，使得其和为 t = target-arr[i]。然后使用两个指针start和end分别初始化为 i+1 和 n-1，若 arr[start]+arr[end] 小于 t，则将start自增1；
    // 若 arr[start]+arr[end] 大于 t，则将end自减1；；若  arr[start]+arr[end] 小于 sum，则此时需要统计重复数字的个数，假设跟 A[start] 相同的数字有 ss 个，跟 A[end] 相同的数字有 es 个。
    // 若 A[start] 不等于 A[end]，那么直接用 es 乘以 ss(初始都为1) 就是出现次数了，
    // 但如果 A[start] 等于 A[end]，则相当于在start - end 中选两个数字的不同选法(排列组合),然后直接退出当前循环(因为之后都是一样的数字)
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int result = 0;
        int M = 1000000000+7;
        for(int i = 0; i < arr.length - 2; i++){
            int start = i + 1;
            int end = arr.length - 1;
            int t = target - arr[i];
            //是否需要直接退出大循环
            boolean repeatflag = false;
            while(end > start && !repeatflag){
                int ss = 1;
                int es = 1;
                while(end >= start && arr[end] + arr[start] == t){
                    //遍历重复的元素，控制end不与start重合
                    if(end - 1 > start && arr[end - 1] == arr[end]){
                        end--;
                        es++;
                    }
                    else if(start + 1 < end && arr[start + 1] == arr[start]){
                        start++;
                        ss++;
                    }
                    else{
                        if(arr[end] != arr[start]){
                            result += ss * es;
                            end--;
                            start++;
                            break;
                        }
                        else{
                            end = end + es - 1;
                            //排列组合运算
                            result += (end - start) * (end - start + 1) / 2;
                            //直接取摸，不能在return的时候取
                            result %= M;
                            //直接退出大循环
                            repeatflag = true;
                            break;
                        }
                    }
                }
                if(arr[end] + arr[start] > t){
                    end--;
                }
                else if(arr[end] + arr[start] < t){
                    start++;
                }
            }
        }
        return result;
    }
}
