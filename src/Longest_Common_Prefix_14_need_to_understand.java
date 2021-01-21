public class Longest_Common_Prefix_14_need_to_understand {
    //brute force
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder answ = new StringBuilder();
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        int minLength = strs[0].length();      //得出所有字符串中最短的长度
        for(int i = 1; i < strs.length; i++){
            if (strs[i].length() < minLength){
                minLength = strs[i].length();
            }
        }
        for (int i = 0; i < minLength; i++){        //第i个字符
            char aux = strs[0].charAt(i);
            int j = 1;
            while (strs[j].charAt(i) == aux){       //第i个字符，各个String进行比对
                j++;
                if(j == strs.length){           //一旦搜索完就结束
                    break;
                }
            }
            if (j ==  strs.length ){        //字符全匹配则加进答案
                answ.append(aux);
            }
            else {
                break;          //一旦有不匹配，立刻结束
            }
        }
        return answ.toString();
    }
    // Horizontal scanning
    public static String longestCommonPrefix_2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];        //假设prefix为第一个字符串全部
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {  //IndexOf : 返回指定字符首次出现在此字符串中的索引。 此处的意思是，当此值为0时，表示此时的prefix是有效的（从开头开始匹配）
                prefix = prefix.substring(0, prefix.length() - 1);      //不断缩短prefix直到有效
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
    //Vertical scanning
    public static String longestCommonPrefix_3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)           //一旦发现不同或搜索完了就立刻截字符
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];             //之前没被截，则表示预设的字符串是答案
    }
    //Divide and conquer
    public String longestCommonPrefix_4(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);      //前半部分的commonPrefix
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);  //后半部分的commonPrefix
            return commonPrefix(lcpLeft, lcpRight);         //合在一起的prefix
        }
    }
    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
    //Binary search
    public String longestCommonPrefix_5(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))       //找到位置后，筛选范围
                low = middle + 1;           //[0，middle]都匹配，则搜索middle之后的
            else
                high = middle - 1;           //[0，middle]不匹配，则搜索middle之前的
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
    public static void main(String[] args){
        String[] strs = {"added","adde"};
        System.out.println(longestCommonPrefix(strs));
    }
}
