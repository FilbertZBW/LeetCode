//Really similar to 2.Add Two Numbers. Even simpler!

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int pointer1 = num1.length() - 1;
        int pointer2 = num2.length() - 1;
        int carry = 0;
        
        while(pointer1 >= 0 || pointer2 >= 0){
            int sum = carry;
            if(pointer1 >= 0){
                sum += num1.charAt(pointer1) - '0';
            }
            if(pointer2 >= 0){
                sum += num2.charAt(pointer2) - '0';
            }
            res.append(sum % 10);
            carry = sum / 10;
            pointer1--;
            pointer2--;
        }
        
        if(carry == 1){
            res.append(1);
        }
         return res.reverse().toString();
    }
}
