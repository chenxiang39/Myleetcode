public class Shortest_Word_Distance_243_need_review {
    //one pass way
    //n: the length of words
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int shortestDistance(String[] words, String word1, String word2) {
        //记录word1和word2的位置
        int p1 = -1;
        int p2 = -1;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < words.length;i++){
            if(words[i].equals(word1)){
                p1 = i;
                //每次发现新位置都进行结果的更新
                if(p1 != -1 && p2 != -1){
                    result = Math.min(result, Math.abs(p1 - p2));
                }
            }
            else if(words[i].equals(word2)){
                p2 = i;
                //每次发现新位置都进行结果的更新
                if(p1 != -1 && p2 != -1){
                    result = Math.min(result, Math.abs(p1 - p2));
                }
            }

        }
        return result;
    }
}
