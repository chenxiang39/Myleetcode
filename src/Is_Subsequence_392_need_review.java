public class Is_Subsequence_392_need_review {
    //双指针
    //时间复杂度： O(t.length())
    //空间复杂度： O(1)
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int p1 = 0;
        int p2 = 0;
        while(p1 < s.length() && p2 < t.length()){
            //匹配的话两个指针都向后推
            if(s.charAt(p1) == t.charAt(p2)){
                p1++;
                p2++;
            }
            //不匹配的话，target的指针继续向后遍历
            else{
                p2++;
            }
            //p1指针全部遍历完的话就返回true
            if(p1 == s.length()){
                return true;
            }
        }
        //target全部都遍历完了还没匹配就返回false
        return false;
    }
}
