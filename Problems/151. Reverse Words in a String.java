//no need to explain

class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = str.length - 1; i >= 0; i--){
            sb.append(str[i]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}