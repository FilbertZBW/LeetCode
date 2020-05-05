//just binary search!

class Solution {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        long start = 0;
        long end = x;
        
        while(start < end - 1){
            long mid = (start + end)/2;
            if(mid*mid == x){
                return (int)mid;
            }else if(mid*mid < x){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        return (int)start;
    }
}