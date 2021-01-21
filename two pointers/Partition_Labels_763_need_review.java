import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Partition_Labels_763_need_review {
    //Two pointers, Greedy
    //https://www.cnblogs.com/grandyang/p/8654822.html
    //时间复杂度：O(S.length)
    //空间复杂度：O(S.length),HashMap
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        //key:字符， value:记录对应的字符出现在s中的最后的位置
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            map.put(S.charAt(i),i);
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < S.length(); i++){
            //每当遍历新字符时，查看对应字符出现的最后位置并更新end指针，当i等于end时，
            //说明此时出现的所有字母已经全部不可能在之后出现了，这时候断开并更新start指针到end之后（重新开始记录下一段）
            if(end < map.get(S.charAt(i))){
                end = map.get(S.charAt(i));
            }
            if(i == end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

}
