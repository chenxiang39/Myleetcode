import com.sun.jdi.Value;

public class Roman_to_Integer_13_not_best {
    public static int romanToInt(String s) {
        char[] sc =  {'I','V','X','L','C','D','M'};
        int[] valueSC = {1,5,10,50,100,500,1000};
        int answ = 0;
        for (int i = 0; i < s.length() ; i++){
            for (int j = 0; j < sc.length; j++) {
                if (s.charAt(i) == sc[j]){
                    if (i + 1 < s.length()){
                        //遇到叠起来的字符，算出后面的字符并让i+1跳过两个连起来的字符
                        if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'V'){
                            answ += 4;
                            i = i + 1;
                            break;
                        }
                        if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'X'){
                            answ += 9;
                            i = i + 1;
                            break;
                        }
                        if(s.charAt(i) == 'X' && s.charAt(i + 1) == 'L'){
                            answ += 40;
                            i = i + 1;
                            break;
                        }
                        if(s.charAt(i) == 'X' && s.charAt(i + 1) == 'C'){
                            answ += 90;
                            i = i + 1;
                            break;
                        }
                        if(s.charAt(i) == 'C' && s.charAt(i + 1) == 'D'){
                            answ += 400;
                            i = i + 1;
                            break;
                        }
                        if(s.charAt(i) == 'C' && s.charAt(i + 1) == 'M'){
                            answ += 900;
                            i = i + 1;
                            break;
                        }
                    }
                    answ += valueSC[j];     //单字符直接加
                }
            }
        }
        return answ;
    }
    public static void main(String[] args){
        System.out.println(romanToInt("MCMXCIV"));
    }
}
