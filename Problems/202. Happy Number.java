class Solution {
    public boolean isHappy(int n) {     
        // We'd expect continually following links to end in one of the following ways:
        // It eventually gets to 1.
        // It eventually gets stuck in a cycle.
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        
        return n == 1;
    }
    
    private int getNext(int n){
        int sum = 0;
        while(n > 0){
            int d = n % 10;
            n /= 10;
            sum += d*d;
        }
        return sum;
    }
}