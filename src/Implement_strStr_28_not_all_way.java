public class Implement_strStr_28_not_all_way {
    //Use java Api
    public static int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0){     //注意此处特殊情况
            return 0;
        }
        if (haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        else {
            return -1;
        }
    }
    //loop
    public static int strStr_2(String haystack, String needle) {
        if(needle.length() == 0){     //注意此处特殊情况
            return 0;
        }
        for (int start = 0; start <= haystack.length() - needle.length(); start++){     //注意有小于等于
            int offset;
            for (offset = 0; offset < needle.length(); offset++){   //匹配以start开始的之后的needle.length()个字符串是否匹配
                if (haystack.charAt(start + offset) != needle.charAt(offset)){
                    break;                  //不匹配立刻退出循环
                }
            }
            if(offset == needle.length()){         //如果全部匹配
                return start;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(strStr_2("adllzz","z"));
    }
}
