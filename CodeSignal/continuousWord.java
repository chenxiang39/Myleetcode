public class continuousWord {
    public static boolean continuousWord(String[] strArr){
        int length = strArr.length;
        for(int i = 0; i < length - 1; i++){
            if (!isEqual(strArr[i],strArr[i + 1])){
                return false;
            }
        }
        return true;
    }
    public static boolean isEqual(String a, String b){
        if(a.charAt(0) != b.charAt(0)){
            return false;
        }
        else if(a.charAt(a.length() - 1) != b.charAt(b.length() - 1)){
            return false;
        }
        else {
            return true;
        }
    }
    public static void main(String[] args) {
        String[] arr = {"abcd","acd","abd"};    //首尾连续
        System.out.println(continuousWord(arr));
    }
}
