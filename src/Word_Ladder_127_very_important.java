import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS(非常慢)
// 时间复杂度: O(N^2 * M),N表示wordList的长度，M表示每个单词的长度
// 空间复杂度: O(N),队列存放wordList
// 思路：https://www.cnblogs.com/springfor/p/3893499.html
// 这道题是套用BFS同时也利用BFS能寻找最短路径的特性来解决问题。
// 把每个单词作为一个node进行BFS。当取得当前字符串时，对其进行转换试探，如果可以达到的转换结果在字典里面，就入队，并将下层result++，并且为了避免环路，
// 需把在字典里检测到的单词从字典里删除。这样对于当前字符串进行转换试探后，在queue中的单词就作为下一层需要遍历的单词了。
// 正因为BFS能够把一层所有可能性都遍历了，所以就保证了一旦找到一个单词equals（end），那么return的路径肯定是最短的。
public class Word_Ladder_127_very_important {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        //特殊情况
        if(beginWord == null || endWord == null || !wordList.contains(endWord)){
            return result;
        }
        int length = wordList.size();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);     //从开始单词开始
        while(!q.isEmpty()){
            int size = q.size();
            result++;
            for(int i = 0; i < size; i++){
                String aux = q.poll();          //每个队列的字符是否能变换成wordList中剩余的其他字符（是否能变换成endWord）
                if(canTransfer(aux,endWord)){   //如果能变换到结果
                    result++;       //直接跳过下一轮，直接返回结果
                    return result;
                }
                for(int j = 0; j < length; j ++){       //否则将能变换的结果加入到队列中
                    String s = wordList.get(j);
                    if(s == null){          //需要null跳过
                        continue;
                    }
                    if(canTransfer(aux,s)){
                        q.offer(s);
                        wordList.set(j,null);       //遍历过的设置成null
                    }
                }
            }
        }
        return 0;
    }
    private static boolean canTransfer(String a, String b){
        int changeAmount = 0;
        for (int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                changeAmount++;
            }
        }
        return changeAmount == 1;
    }
    public static void main(String[] args){
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("cog");
        wordList.add("pot");
        wordList.add("dot");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
}
