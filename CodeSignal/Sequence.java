public class Sequence {
    public static int sequence(String word, String seq){
        int result = 0;
        int Count = 0;
        for(int i = 0; i < seq.length() - word.length() + 1; i++){
            int j = i;
            for(; j < i + word.length(); j++){
                if(seq.charAt(j) != word.charAt(j - i)){
                    Count = 0;
                    break;
                }
            }
            if(j == word.length() + i){
                Count++;
                i = i + word.length() - 1;
                result = Math.max(Count,result);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String word = "ab";
        String sequence = "dabababab";  //连续ab
        System.out.println(sequence(word,sequence));
    }
}
