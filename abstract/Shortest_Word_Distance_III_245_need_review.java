public class Shortest_Word_Distance_III_245_need_review {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int p1 = -1;
        int p2 = -1;
        boolean isWord1 = true;
        //分word1与word2相等与不相等两种情况
        //不相等时word1与word2就是243题
        //相等时设置flag进行切换，然后运算距离
        for(int i = 0; i < words.length; i++){
            if(word1.equals(word2)){
                if(words[i].equals(word1)){
                    if(isWord1){
                        p1 = i;
                    }
                    else{
                        p2 = i;
                    }
                    if(p1 != -1 && p2 != -1){
                        result = Math.min(result, Math.abs(p1 - p2));
                    }
                    isWord1 = !isWord1;
                }
            }
            else{
                if(words[i].equals(word1)){
                    p1 = i;
                    if(p1 != -1 && p2 != -1){
                        result = Math.min(result, Math.abs(p1 - p2));
                    }
                }
                if(words[i].equals(word2)){
                    p2 = i;
                    if(p1 != -1 && p2 != -1){
                        result = Math.min(result, Math.abs(p1 - p2));
                    }
                }
            }
        }
        return result;
    }
}
