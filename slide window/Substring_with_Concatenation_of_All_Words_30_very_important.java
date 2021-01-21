import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Substring_with_Concatenation_of_All_Words_30_very_important {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s.length()  == 0 || words.length == 0){
            return result;
        }
        //Slide window
        //https://www.bilibili.com/video/BV1B7411z7KA?from=search&seid=13439959159336021056
        //Time complexity: O(N * M), N : the length of s, M : words[0].length
        //Space complexity: O(M) ==> two Maps
        int wordlength = words[0].length();
        int wordCount = words.length;
        int totallength = wordlength * wordCount;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> window = new HashMap<>();
        for (int i = 0; i < wordCount; i++){
            String sm = words[i];
            if(map.containsKey(sm)){
                map.put(sm, map.get(sm) + 1);
            }
            else{
                map.put(sm, 1);
            }
        }
        for(int i = 0; i <= s.length() - totallength ; i++){
            window.clear();
            int j = i;
            for(j = i; j < i + totallength; j = j + wordlength){
                String sw = s.substring(j, j + wordlength);
                if(!map.containsKey(sw)){
                    break;
                }
                else{
                    if(window.containsKey(sw)){
                        if(window.get(sw) < map.get(sw)){
                            window.put(sw, window.get(sw) + 1);
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        window.put(sw, 1);
                    }
                }
            }
            //if not break, means window's content meet the requirements
            if(j == i + totallength){
                result.add(i);
            }
        }
        return result;
    }
}
