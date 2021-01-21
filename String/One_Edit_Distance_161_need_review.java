public class One_Edit_Distance_161_need_review {
    //String
    //Time complexity: O(s.length or t.length)
    //Space complexity: O(1)
    public boolean isOneEditDistance(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        //相差超过一位
        if(Math.abs(sl - tl) > 1){
            return false;
        }
        //等位,每一位进行核对，看最后的不同是不是1个
        if(sl == tl){
            int dif = 0;
            for(int i = 0; i < sl; i++){
                if(s.charAt(i) != t.charAt(i)){
                    dif++;
                }
            }
            return dif == 1;
        }
        //差一位
        else{
            if(sl == 0 || tl == 0){
                return true;
            }
            int diff = 0;       //不同的地方
            int sp = 0;         //遍历s的指针
            int tp = 0;         //遍历t的指针
            //防止有其中一个长度只是为1的情况，所以要两个同时在范围内
            while(sp < sl && tp < tl){
                if(s.charAt(sp) != t.charAt(tp)){
                    if(diff == 0){
                        diff++;
                        if(sl > tl){
                            sp++;       //遇到第一不同后，将长的字符的指针向后移一位
                        }
                        else{
                            tp++;
                        }
                        continue;
                    }
                    else{
                        return false;
                    }
                }
                //继续遍历
                sp++;
                tp++;
            }
            return true;
        }
    }
}
