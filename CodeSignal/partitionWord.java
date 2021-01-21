public class partitionWord {
    public static String[] partitionword(String str){
        String[] result = new String[3];
        for(int i = 1; i < str.length() - 1; i++){
            for (int j = i + 1; j < str.length(); j++){
                String a = str.substring(0,i);
                String b = str.substring(i,j);
                String c = str.substring(j);
                if(a + b != c + a && a + b != b + c && c + a != b + c){
                    result[0] = a;
                    result[1] = b;
                    result[2] = c;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "sdgaf";
        String[] r = partitionword(str);
        for(String s : r) {
            System.out.println(s);
        }
    }
}
