public class Valid_Anagram_242_not_all_way {
    //Use HashTable, can solve follow up problem
    //n : the length of s or t
    //Time complexity: O(n)
    //Space complexity: O(1),constant
    public boolean isAnagram(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if(lengthS != lengthT){
            return false;
        }
        //create HashTable
        int[] HashTable = new int[26];
        //meet same character, calculate
        for(int i = 0; i < lengthS; i++){
            HashTable[s.charAt(i) - 'a']++;
            HashTable[t.charAt(i) - 'a']--;
        }
        //check
        for(int num : HashTable){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}
