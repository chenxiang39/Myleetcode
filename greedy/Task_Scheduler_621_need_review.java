public class Task_Scheduler_621_need_review {
    //greedy
    //https://blog.csdn.net/thesnowboy_2/article/details/73556561
    //https://www.cnblogs.com/grandyang/p/7098764.html
    //贪心策略：根据字母出现频率降序排序，最高排序的字母安排 n + 1个槽位，
    //然后分配出现该字母频率 - 1的次数（必须需要这么多的时间），然后最后一次出现时，只需加跟最高频率出现次数一样的字母的数量
    //以上算出来的是理论最小值，如果task的长度超过了这个值，就直接输出task的长度
    //时间复杂度：O(tasks.length)
    //空间复杂度：O(1), dict array
    public int leastInterval(char[] tasks, int n) {
        int[] dict = new int[26];
        for(char c : tasks){
            dict[c - 'A']++;
        }
        int maxflu = 0; //出现最大频率数
        int maxfluCount = 0; //出现最大频率的次数
        for(int flu : dict){
            maxflu = Math.max(maxflu, flu);
        }
        for(int flu : dict){
            if(flu == maxflu){
                maxfluCount++;
            }
        }
        //理论值
        int result = (maxflu - 1) * (n + 1) + maxfluCount;
        if(tasks.length > result){
            return tasks.length;
        }
        else{
            return result;
        }
    }
}
