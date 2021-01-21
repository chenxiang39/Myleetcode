import java.util.HashMap;

public class Isomorphic_Strings_205_need_review {
    //Hashmap, 与242一起分析
    //Time complexity: O(s.length)
    //Space complexity: O(s.length), Hashmap
    public boolean isIsomorphic(String s, String t) {
        //使用hashmap存储s和t中配对的字符，如果出现不配对，说明不是同构词
        HashMap<Character, Character> map = new HashMap<>();        //key为s中的字符，value为t中的字符
        for(int i = 0 ; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){             //key没出现过，但value出现过
                    return false;
                }
                else{
                    map.put(s.charAt(i),t.charAt(i));           //两者都没出现过，加入map
                }
            }
            else{
                if(t.charAt(i) != map.get(s.charAt(i))){        //出现过key, 但value不匹配
                    return false;
                }
            }
        }
        return true;
    }
}
