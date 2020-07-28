class Solution {
    public int myAtoi(String str) {
        int res = 0;
        
        if(str == null || str.length() == 0){
            return 0;
        }
        
        //Exclude whitespace
        int index = 0;
        while(index < str.length() && str.charAt(index) == ' '){
            index++;
        }
        
        if(index == str.length()){
            return 0;
        }
        
        
        int sign = 1;
        //judge positive or negative
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            if(str.charAt(index) == '+'){
                sign = 1;
            }else{
                sign = -1;
            }
            index++;
        }
        
        
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            //from the first non-whitespace non-sign position, tell if it is a digit
            if(digit > 9 || digit < 0){
                break;
            }
            int newRes = res * 10 + digit;
            //check whether it goes out of bounds
            if(Integer.MAX_VALUE/10 < res || (res * 10 > res * 10 + digit)){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = newRes;
            index++;
        }
        
        return res*sign;
        
    }
}