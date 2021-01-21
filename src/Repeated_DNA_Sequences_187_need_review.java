import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Repeated_DNA_Sequences_187_need_review {
    public List<String> findRepeatedDnaSequences(String s) {
        //Time complexity : O((N−L)L), that is O(N) for the constant L = 10（字串长度）. In the loop executed N - L + 1 one builds a substring of length L. Overall that results in O((N−L)L) time complexity.
        //Space complexity : O((N−L)L) to keep the hashset, that results in O(N) for the constant L = 10.
        HashSet<String> dist = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++){
            String st = s.substring(i, i + 10); // N - L + 1的时间复杂度
            if(!dist.contains(st)){
                dist.add(st);
            }
            else{
                result.add(st);     //重复出现的加入result(符合题意要求的10个字符的相同连续串出现的次数超过一次),由于此时result是hashSet类型（无法加入重复的元素），即使重复的字符串出现次数超过2次，也没有问题
            }
        }
        return new ArrayList(result);
    }
    //用HashMap
    public List<String> findRepeatedDnaSequences_2(String s) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> dist = new HashMap<>();        //value表示出现的次数
        for (int i = 0; i < s.length() - 9; i++){
            String st = s.substring(i, i + 10);
            if(!dist.containsKey(st)){
                dist.put(st,1);
            }
            else{
                if(dist.get(st) == 1){          //已经出现一次了，再出现的情况就放进result,之后再出现不会重复加进result，因为value不为1
                    result.add(st);
                    dist.put(st,dist.get(st) + 1);
                }
            }
        }
        return result;
    }
}
