import java.util.*;

public class Word_Break_139_very_improtant {
    //bfs
    //Time complexity : O(n^2)
    //For every starting index, the search can continue till the end of the given string.
    //Space complexity : O(n). Queue of at most n size is needed.
    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] isVis = new boolean[length];      //是否访问过
        Queue<Integer> q = new LinkedList<>();
        HashSet<String> set = new HashSet(wordDict);
        q.offer(0);
        while(!q.isEmpty()){
            int start = q.poll();
            if(!isVis[start]){      //没访问过的点进行进队列检查(可能几种组合会到达同一个字符，可以省略)
                for(int end = start + 1; end <= length; end++){
                    if(set.contains(s.substring(start,end))){       //标记新字符的初始位
                        if(end == length){
                            return true;
                        }
                        q.offer(end);
                    }
                }
                isVis[start] = true;
            }
        }
        return false;
    }
    //dp
    //Time complexity : O(n^2)
    //Two loops are their to fill dp array.
    //Space complexity : O(n). Length of dp array is n+1.
    public static boolean wordBreak_2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];         //保存从开始能到的最末端的字符是否能由字典中的单词拼接而成
        HashSet<String> set = new HashSet(wordDict);
        dp[0] = true;
        for (int end = 1; end <= s.length(); end++){
            for(int start = 0; start < end; start++){
                if(dp[start] && set.contains(s.substring(start, end))){
                    dp[end] = true;         //能达到则设置为true
                }
            }
        }
        return dp[s.length()];      //是否能到达s的最末端
    }
    public static void main(String[] args){
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak(s,wordDict));
    }
}
