class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                break;
            }
            digits[i] = 0;
        }
        
        //It means it was like 9999 previously and we have to add one as the first digit
        if(digits[0] == 0){
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for(int i = 0; i < digits.length; i++){
                ans[i+1] = digits[i];
            }
            return ans;
        }
        return digits;
    }
}