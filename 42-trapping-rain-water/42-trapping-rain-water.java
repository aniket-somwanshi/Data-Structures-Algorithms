class Solution {
    /*
    O(N) O(1)
    Put i on left and j on right end
    we calculate the outer container that can contain some water
    Assuming there are no buildngs inside it, there will be all water
    So this is our inintial water amt
    Now since there are buildings inside this boundary, 
    If we get a building, we should decrease the amt of water, 
    as the space is actually occupied by the building
    If we get i and j such that building-i and building j-i can become
    containers of larger height that the current containers level,
    we will increase our max possible water amt by the 
    increased height*distance between them
    For moving i and j, we say always move the smaller height pointer
    keep moving until we cover all the buildings
    */
    public int trap(int[] height) {
        int i = 0;
        int j = height.length-1;
        int currentLevel = 0;
        int totalWater = 0;
        while (i < j) {
            int newLevel = Math.min(height[i], height[j]);
            if (newLevel > currentLevel) {
                int increaseInLevel = newLevel - currentLevel;
                totalWater += increaseInLevel * (j - i - 1);
                currentLevel = newLevel;
            }
            // move pointers
            if (height[i] <= height[j]) {
                i++;
                // decrease totalWater due to building being here
                if (i < j) totalWater -= Math.min(currentLevel, height[i]);
                
            }
            else {
                j--;
                if (i < j) totalWater -= Math.min(currentLevel, height[j]);
            }
        }
        
        return totalWater;
    }
}