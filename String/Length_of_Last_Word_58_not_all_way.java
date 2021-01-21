public class Length_of_Last_Word_58_not_all_way {
    public int lengthOfLastWord(String s) {
        s = s.trim();       //去掉首尾空格
        int result = 0;
        int pointer = s.length() - 1;       //从最后开始指向前面
        while(pointer >= 0 && s.charAt(pointer)!= ' '){
            result++;       //能推进多少，则表示最后一个单词的长度
            pointer--;
        }
        return result;
    }
}
