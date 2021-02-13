import java.util.HashMap;

public class Split_Array_into_Consecutive_Subsequences_659_need_review {
    //greedy
    //https://www.cnblogs.com/grandyang/p/7525821.html
    //https://www.bilibili.com/video/BV14K4y1L7HX?from=search&seid=12803383462340799505
    //时间复杂度：O(nums.length)
    //空间复杂度：O(nums.length)
    public boolean isPossible(int[] nums) {
        //key:组成序列的最后一个数字， value:该序列存在的数量
        HashMap<Integer, Integer> seq = new HashMap<>();
        //key:序列的数字,value：数字对应出现的频率
        HashMap<Integer, Integer> count = new HashMap<>();
        //计算频率
        for(int num : nums){
            count.put(num,count.getOrDefault(num, 0) + 1);
        }
        for(int num : nums){
            //如果当前数字计算的频率为0，则忽略(已经被组成序列了)
            if(count.getOrDefault(num, 0) == 0){
                continue;
            }
            //如果序列中没有一个序列能让当前数字接在后面的，则该数字自己开启序列
            if(seq.getOrDefault(num - 1, 0) == 0){
                //如果以该数字为首，后面两个 + 1和 + 2的数字不存在或者频率为0，则当前数字不能组成序列，也无法被接入之前的序列，返回false
                if(count.getOrDefault(num + 1, 0) == 0 || count.getOrDefault(num + 2, 0) == 0){
                    return false;
                }
                //如果可以组成序列，则添加序列（暂定该序列的最后一个数字是num + 2,因为题目要求一个序列至少有3个数字）
                else{
                    seq.put(num + 2, seq.getOrDefault(num + 2, 0) + 1);
                    //频率减1，证明被使用过1次
                    count.put(num, count.get(num) - 1);
                    count.put(num + 1, count.get(num + 1) - 1);
                    count.put(num + 2, count.get(num + 2) - 1);
                }
            }
            //能直接接上之前存在的序列，则接上
            else{
               //更新原先序列的存在数量
                seq.put(num - 1, seq.get(num - 1) - 1);
                //更新序列的最后一个数字为当前数字
                seq.put(num, seq.getOrDefault(num, 0) + 1);
                //更新频率
                count.put(num, count.get(num) - 1);
            }
        }
        //完全没问题，返回true
        return true;
    }
}
