import java.util.List;

public class Longest_Word_in_Dictionary_through_Deleting_524_need_review {
    //brute force
    //two pointers
    //最直接的方法找
    //时间复杂度：O(n * x), Here n refers to the number of strings in list d and x refers to average string length.
    //空间复杂度：O(x), x
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for(String str : d){
            if(detect(s,str)){
                //每次记录长度长的或者按字母排序
                if(str.length() > result.length() || str.length() == result.length() && str.compareTo(result) < 0){
                    result = str;
                }
            }
        }
        return result;
    }
    //探测当前的字符串是否匹配
    public boolean detect(String s, String d){
        int ps = 0;
        int pd = 0;
        while(ps < s.length() && pd  < d.length()){
            if(s.charAt(ps) == d.charAt(pd)){
                pd++;
            }
            ps++;
        }
        return pd == d.length();
    }
}
