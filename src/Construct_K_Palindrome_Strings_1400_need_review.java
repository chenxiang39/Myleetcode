import java.util.HashMap;
import java.util.Map;

public class Construct_K_Palindrome_Strings_1400_need_review {
    //Use HashMap
    //Time complexity: O(s.length)
    //Space complexity: O(s.length)
    public boolean canConstruct(String s, int k) {
        //corner case
        if(s.length() < k){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();       //key : character, Value: appear times
        for(Character c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else{
                map.put(c,map.get(c) + 1);
            }
        }
        int oddPair = 0;    //not even
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 == 1){
                oddPair++;
            }
        }
        return oddPair <= k;        //出现的奇数不大于k就是true
    }
}
