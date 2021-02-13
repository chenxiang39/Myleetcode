public class Monotone_Increasing_Digits_738_need_review {
    public int monotoneIncreasingDigits(int N) {
        //greedy
        //时间复杂度：O(N.length),N ==> N转换成String的长度
        //空间复杂度：O(N.length)
        StringBuilder result = new StringBuilder();
        String Nstr = String.valueOf(N);
        for(int i = 0; i < Nstr.length(); i++){
            //加入第一个字符串
            if(i == 0){
                result.append(Nstr.charAt(i));
            }
            else{
                //如果新加的字符比之前的字符大或者相等，就直接添加进result
                if(Nstr.charAt(i) >= Nstr.charAt(i - 1)){
                    result.append(Nstr.charAt(i));
                }
                //如果新加的字符比之前的字符小
                else{
                    int j = i;
                    //回退，把等于或小于之前的数字都删除(等于的数字不能留在答案里，因为当前位需要减1)
                    while(j > 0 && Nstr.charAt(j) <= Nstr.charAt(j - 1)){
                        j--;
                        result.delete(j,i);
                    }
                    char first = Nstr.charAt(j);
                    //当前删除位如果小于2，则代表需要退位（1-1等于0，一定不比前一位大）
                    if(first - '2' < 0){
                        result.delete(j, j);
                    }
                    //当前删除位如果不小于2，则代表不需要退位(直接减1)
                    else{
                        result.append(first - '1');
                    }
                    //按位数加入9
                    for(int z = 0; z < Nstr.length() - 1 - j; z++){
                        result.append('9');
                    }
                    break;
                }
            }
        }
        return Integer.valueOf(result.toString());
    }
}
