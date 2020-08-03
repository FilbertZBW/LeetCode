//硬Reverse就完事儿了

class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        for(int i = 0; i < str.length; i++){
            char[] c = str[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int j = c.length - 1; j >= 0; j--){
                sb.append(c[j]);
            }
            str[i] = sb.toString();
        }
        
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            sb1.append(str[i]);
            sb1.append(' ');
        }
        
        return sb1.toString().trim();
    }
}