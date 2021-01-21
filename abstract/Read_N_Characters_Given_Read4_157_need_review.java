public class Read_N_Characters_Given_Read4_157_need_review {
    public int read(char[] buf, int n) {
        int result = 0;
        int readAmount = 4;
        char[] buf4 = new char[4];
        //如果读取数量到不了4，说明剩下的字符（readAmount < 4）不够了，就可以退出循环,直接输出答案
        while(result < n && readAmount == 4){
//            readAmount = read4(buf4);
            for(int i = 0; i < readAmount; i++){
                if(result == n){        //等于n就直接输出
                    return result;
                }
                buf[result] = buf4[i];
                result++;   //读取一个就result加1
            }
        }
        return result;
    }
}
