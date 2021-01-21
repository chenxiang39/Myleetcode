public class Reverse_Words_in_a_String_151_need_review {
    //two pointers
    //Time complexity: O(s.length)
    //Space complexity: O(s.length), result
    public String reverseWords(String s) {
        s = s.trim();   //去掉首尾空格
        if(s.length() == 1){
            return s;
        }
        StringBuilder result = new StringBuilder();
        //倒序遍历
        //start表示遍历到一个单词的开头
        //end表示一个单词的结尾
        int start = s.length() - 1;
        int end = s.length() - 1;
        while(end > 0){
            //start指针向前遍历，因为还没遇到空格，说明不是单词的开头
            if(start > 0 && s.charAt(start) != ' '){
                start--;
                continue;
            }
            //start和end都遍历到了空格，说明此时的位置是单词与单词之间的空格，需要两个指针一起向前
            if(s.charAt(start) == ' ' && start == end){
                start--;
                end--;
                //防止第一个单词只有一个字母，start 和 end都为0,则直接进行后面的步骤，不重新循环
                if(start != 0){
                    continue;
                }
            }
            //将start和end之间的单词加入result，start指向的是空格，是单词之前的那个空格，因此要截取start + 1
            if(start != 0){
                result.append(s.substring(start + 1, end + 1));
            }
            //start为0,到了开头的情况，start到不了第一个单词之前的空格，因为开头的trim已经把首尾空格去掉了
            else{
                result.append(s.substring(start, end + 1));
            }
            result.append(' '); //每个单词添加完后加空格
            end = start;    //结束当前单词的添加，将end移到start的位置
        }
        return result.toString().trim();    //将结果的末尾的空格去掉
    }
}
