public class Add_Binary_67_not_all_way {
    //my way
    //时间复杂度为O(math.max(n,m)); 双指针同步遍历      n和m分别代表a和b的字符串长度
    //空间复杂度为O(n + m);       //StringBuilder的长度，根据答案而改变
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int alen = a.length() - 1;
        int blen = b.length() - 1;
        int carry = 0;      //进位
        int origin;
        while (alen >= 0 || blen >= 0){
            //如果a字符串空了
            if(alen < 0){
                origin = 0 +  (b.charAt(blen)-'0') + carry;
                result.append(origin%2);
                carry = origin/2;
                blen--;
                continue;
            }
            //如果b字符串空了
            if(blen < 0){
                origin = 0 +  (a.charAt(alen)-'0') + carry;
                result.append(origin%2);
                carry = origin/2;
                alen--;
                continue;
            }
            //都没空
            else {
                origin = (a.charAt(alen)-'0') +  (b.charAt(blen)-'0') + carry;      //加进位
                result.append(origin%2);        //插入值
                carry = origin/2;       //运算进位
                alen--;         //往回倒退
                blen--;         //往回倒退
            }
        }
        //如果最后有要进位的，因为长度不够，还没来得及加进result
        if(carry == 1){
            result.append(1);
        }
        return result.reverse().toString(); //输出倒转的字符串
    }
    public static void main(String[] args){
        String result = addBinary("0","0");
        System.out.println(result);
    }
}
