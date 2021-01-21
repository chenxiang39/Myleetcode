public class Excel_Sheet_Column_Title_168_need_to_understand {
    public static String convertToTitle(int n) {
        String[] dict = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String s = new String();
        while (n != 0) {
            int aux = n % 26;
            if (aux == 0) {       //处理余数为0的情况，把z先加入，因为此时n不为0,将n减掉26
                s = dict[26] + s;
                n = n - 26;
            } else {
                s = dict[aux] + s;
            }
            n = n /26 ;
        }
        return s;
    }
    public static void main(String[] args){
        int n = 17576;
        System.out.println(convertToTitle(n));
    }
}
