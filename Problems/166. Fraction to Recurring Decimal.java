//Just recall the process of doing division manually!


class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        //if negative number, append minus sign.
        if((numerator > 0 && denominator < 0) ||(numerator < 0 && denominator > 0)){
            sb.append("-");
        }
        
        //Imagine the denominator is Integer.MIN_VALUE. If you take abs, it overflows.
        //So we could avoid this by using long type.
        long divisor = Math.abs((long)numerator);
        long dividend = Math.abs((long)denominator);

        //append the figure before the decimal
        sb.append(divisor/dividend);
        
        long remainder = divisor % dividend;
        if(remainder == 0){
            return sb.toString();
        }
        
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(remainder != 0){
            //if duplicate number found, we could append parenthesis and return result.
            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }

            //if not found, put in the map and continue division
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / dividend);
            remainder %= dividend;
        }
        
        return sb.toString();
    }
}