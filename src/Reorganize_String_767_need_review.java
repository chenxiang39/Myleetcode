import java.util.HashMap;
import java.util.PriorityQueue;

public class Reorganize_String_767_need_review {
    //Greedy
    //贪心策略： 初选次数多的字符排前面，使用一个最大堆，将次数当做排序的 key，把次数和其对应的字母组成一个 pair，放进最大堆中自动排序，然后根据次数拼接答案
    //时间复杂度：O(S.length() * logA), A 为 S出现的不同字符的数量
    //空间复杂度：O(A)
    static public String reorganizeString(String S) {
        //Key:字符, Value:出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        //找到出现最多次的次数
        int maxCount = 0;
        for(char c : S.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
            if(maxCount < map.get(c)){
                maxCount = map.get(c);
            }
        }
        //剪枝
        //如果某个字母出现的频率大于总长度的一半了，那么必然会有两个相邻的字母出现，返回""
        if(maxCount > (S.length() + 1)/2){
            return "";
        }
        StringBuilder result = new StringBuilder();
        //最大堆
        PriorityQueue<pair> maxPQ = new PriorityQueue<pair>(
                (a,b) -> {
                    return b.flu - a.flu;
                }
        );
        for(char c: map.keySet()){
            int flu = map.get(c);
            maxPQ.offer(new pair(c,flu));
        }

        while(maxPQ.size() >= 2){
            //每次弹出出现次数前两名的字符进行拼接
            pair p1 = maxPQ.poll();
            pair p2 = maxPQ.poll();
            result.append(p1.c);
            result.append(p2.c);
            p1.flu--;
            p2.flu--;
            //以下两个加进堆的顺序不能反，
            //因为p1.flu可能等于p2.flu且减完1之后依然是出现频率最高的一对字符,
            //导致下次拼接时出现相同的字符拼在一起(后加进去的p2,即使与p1的频率一样大，也是先弹出p1，再弹出p2)
            if(p1.flu > 0){
                maxPQ.offer(p1);
            }
            if(p2.flu > 0){
                maxPQ.offer(p2);
            }
        }
        if(maxPQ.size() != 0){
            pair p1 = maxPQ.poll();
            result.append(p1.c);
        }
        return result.toString();
    }
    //建立pair
    static public class pair{
        char c;     //字符
        int flu;    //频率
        public pair(char c, int flu){
            this.c = c;
            this.flu = flu;
        }
    }
    public static void main(String [] args){
        System.out.println(reorganizeString("aaabbbc"));
    }
}
