public class Longest_Substring_with_At_Least_K_Repeating_Characters_395_very_important {
    //https://segmentfault.com/a/1190000018182392
    //Divide and Conquer
    public int longestSubstring(String s, int k) {
        int length = s.length();
        if(length == 0){
            return 0;
        }
        int[] hash = new int[26];
        for(int i = 0; i < length; i++){
            hash[s.charAt(i) - 'a']++;
        }
        //分割点,因为这个点的字符出现的次数小于k，不符合规定
        int split = -1;
        for(int i = 0; i < length; i++){
            if(hash[s.charAt(i) - 'a'] > 0 && hash[s.charAt(i) - 'a'] < k){
                split = i;
                break;
            }
        }
        //没有分割点说明整个字符串符合规定
        if(split == -1){
            return length;
        }
        else{
            //分治策略，查看分割点左边的最大长度和右边的最大长度
            int left = longestSubstring(s.substring(0, split),k);
            int right = longestSubstring(s.substring(split + 1, length),k);
            //返回两者中更大的
            return Math.max(left,right);
        }
    }
}
