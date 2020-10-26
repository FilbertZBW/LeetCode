class Solution {
    public boolean isRobotBounded(String instructions) {
        //After carrring out command once, if we return to the origion, 
        //or the direction is not the same as initial direction(0, 1),
        //the robot will stay inside a circle.
        int x = 0;
        int y = 0;
        int[] direction = new int[]{0, 1};
        
        for(int i = 0; i < instructions.length(); i++){
            if(instructions.charAt(i) == 'G'){
                x += direction[0];
                y += direction[1];
            }else if(instructions.charAt(i) == 'L'){
                int temp = direction[0];
                direction[0] = direction[1] * (-1);
                direction[1] = temp;
            }else{
                int temp2 = direction[0];
                direction[0] = direction[1];
                direction[1] = temp2 * (-1);
            }
        }
        
        return (x == 0 && y == 0) || !(direction[0] == 0 && direction[1] == 1);
    }
}