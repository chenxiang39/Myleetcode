//trim() 方法用于删除字符串的头尾空白符。
//java中的单引号表示字符,java中的双引号是字符串。
//单引号引的数据一般是char类型的;双引号引的数据是String类型的。
public class String_to_Integer_atoi_8 {
    public static int myAtoi(String str){
        str = str.trim();
        if (str.length() == 0 ){
            return 0;
        }
        int pos = 0;
        if (str.charAt(0) == '+'){
            pos = 1;
        }
        if (str.charAt(0) == '-'){
            pos = -1;
        }
        String answ = "";
        int ref;
        for (int i = 0; i < str.length(); i++){
            if (pos !=0 && i == 0){         //第一个为"-"或者"+"时跳过当前循环，继续下一次循环
                continue;
            }
            if ((int)str.charAt(i) >= 48 && (int)str.charAt(i) <= 57){       //强制转换成ASCII码
                answ += str.charAt(i);
            }
            else {
                break;
            }
        }
        try {
            ref = Integer.parseInt(answ);
        }catch (Exception e){
            if (answ.length() < 1){     //如果第一个是非"-"，"+"及数字
                return 0;
            }
            if(pos == -1){
                return Integer.MIN_VALUE;
            }
            else {
                return Integer.MAX_VALUE;       //如果超过Int的上限
            }
        }
        if (pos == -1){
            return ref * -1;
        }
        else {
            return ref;
        }
    }
    public static void main(String[] args){
        System.out.println(myAtoi("1 1d"));
    }
}
