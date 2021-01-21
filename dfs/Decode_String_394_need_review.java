public class Decode_String_394_need_review {
    //递归
    //https://www.cnblogs.com/grandyang/p/5849037.html
    //指针设置成全局变量，这样递归的时候，p可以直接指下去，不用重新进行赋值
    int p = 0;
    public String decodeString(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        //遇到过界或者](上一个[]的内容边界)停止
        while( p < length && s.charAt(p) != ']'){
            //遇到字符串直接添加
            if(!Character.isDigit(s.charAt(p))){
                sb.append(s.charAt(p));
                p++;
            }
            //一定是先出现数字，再出现[，因此不会突然遇到[
            else{
                StringBuilder count = new StringBuilder();
                while(Character.isDigit(s.charAt(p))){
                    count.append(s.charAt(p));
                    p++;
                }
                //跳过[
                p++;
                //递归进行[]里面的转化
                String str = decodeString(s);
                //跳过]
                p++;
                //计算数字的大小并重复添加字符串
                int c = Integer.valueOf(count.toString());
                while(c > 0){
                    sb.append(str); //拼接之前[]里的内容
                    c--;
                }
            }
        }
        return sb.toString();
    }
}
