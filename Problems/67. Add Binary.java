class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        
        //a has greater length by default
        if(n < m){
            return addBinary(b, a);
        }
        
        int L = Math.max(n, m);
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int j = m - 1;
        
        //traverse the longer string
        for(int i = L - 1; i >= 0; i--){
            if(a.charAt(i) == '1'){
                carry++;
            }
            
            //if shorter string has been finished traversing, 
            //simply ignore the carrier change
            if(j >= 0 && b.charAt(j) == '1'){
                carry++;   
            }
            j--;
            
            if(carry % 2 == 1){
                sb.append('1');
            }else{
                sb.append('0');
            }
            
            carry /= 2;
        }
        
        //corner case: the first digit
        if(carry == 1){
            sb.append('1');
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}