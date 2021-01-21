import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class digitAnagrams {
    public static int digitAnagrams(int[] num){
        Set<int[]> set = new HashSet<>();
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length; j++){
                if(isA(num[i],num[j])){
                    int[] r = new int[2];
                    r[0] = i;
                    r[1] = j;
                    if(!set.contains(r)){
                        set.add(r);
                    }
                }
            }
        }
        return set.size();
    }
    public static boolean isA(int a, int b){
        String as = String.valueOf(a);
        String bs = String.valueOf(b);
        if(as.length() != bs.length()){
            return false;
        }
        int[] hashTable = new int[10];
        for(int i = 0; i < as.length(); i++){
            hashTable[as.charAt(i) - '0']++;
            hashTable[bs.charAt(i) - '0']--;
        }
        for(int i = 0; i < 10; i++){
            if(hashTable[i] != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {25,35,872,228,53,278,872};
        System.out.println(digitAnagrams(arr));
    }
}
