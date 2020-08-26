class Solution {
    public String intToRoman(int num) {
        int[] arabics = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV","I"};
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < arabics.length; i++){
            while(num >= arabics[i]){
                sb.append(romans[i]);
                num -= arabics[i];
            }
        }
        
        return sb.toString();
    }
}