public class Long_Pressed_Name_925_need_review {
    //two pointers
    //时间复杂度：O(name.length + typed.length)
    //空间复杂度：O(1)
    public boolean isLongPressedName(String name, String typed) {
        int p1 = 0;
        int p2 = 0;
        while(p1 < name.length() && p2 < typed.length()){
            if(name.charAt(p1) != typed.charAt(p2)){
                return false;
            }
            else{
                //查找重复的数字的频率
                int repeatName = 1;
                int repeatType = 1;
                while(p1 < name.length() - 1 && name.charAt(p1 + 1) == name.charAt(p1)){
                    repeatName++;
                    p1++;
                }
                while(p2 < typed.length() - 1 && typed.charAt(p2 + 1) == typed.charAt(p2)){
                    repeatType++;
                    p2++;
                }
                //如果name字母的重复数量比type出现的多。说明不吻合
                if(repeatName > repeatType){
                    return false;
                }
                //指针继续遍历
                p1++;
                p2++;
            }
            //如果某一个指针先遍历完，说明不吻合
            if(p1 == name.length() && p2 < typed.length() || p2 == typed.length() && p1 < name.length()){
                return false;
            }
        }
        return true;
    }
}
