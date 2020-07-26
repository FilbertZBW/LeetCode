class Solution {
    public int maxArea(int[] height) {
// Brute force
//         int maxArea = 0;
//         if(height == null || height.length == 0){
//             return 0;
//         }
        
        
//         for(int i = 0; i < height.length - 1; i++){
//             for(int j = i + 1; j < height.length; j++){
//                 int area = (j - i) * Math.min(height[i], height[j]);
//                 maxArea = Math.max(area, maxArea);
//             }
//         }
        
//         return maxArea;
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        
        //The shorter wall will limit the volume of max water. 
        //The only way is to move the pointer in the shorter side.
        while(l < r){
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        
        return maxArea;
    }
}