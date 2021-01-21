//HashSet简单的理解就是HashSet对象中不能存储相同的数据，存储数据时是无序的。但是HashSet存储元素的顺序并不是按照存入时的顺序（和List显然不同）
//是按照哈希值来存的所以取数据也是按照哈希值取得。存储是无序的这就和C++里的Set就不一样了C++里面的Set是有序的我认为这是在使用时候的主要区别。
//HashMap vs HashSet : https://www.cnblogs.com/zhuyeshen/p/10981194.html,
//https://bit.ly/3iMgDwD

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters_3_not_best {
    //Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by ii and jj.
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int answer = 0;
        Set<Character> set = new HashSet<>();
        while (start < n && end < n){
            // try to extend the range [start, end]
            //滑动窗口思想
            if (! set.contains(s.charAt(end))){
                set.add(s.charAt(end++));
                answer = Math.max(answer, end - start);
            }
            else{
                set.remove(s.charAt(start++));      //发现重复的，将start扩大，直到set不出现s.charAt(start)(要记录每一个连续不同的不同字符串长度)
            }
        }
        return answer;
    }
    //Best way (need to understand)
    public static int lengthOfLongestSubstring_2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public static void main(String[] args){
        int answ = lengthOfLongestSubstring("abcad");
        int answ_2 = lengthOfLongestSubstring_2("abcad");
        System.out.println(answ);
        System.out.println(answ_2);
    }
}
