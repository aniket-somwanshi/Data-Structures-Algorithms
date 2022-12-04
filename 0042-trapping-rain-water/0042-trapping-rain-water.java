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
    public int trap(int[] a) {
        int n = a.length;
        int i = 0;
        int j = n-1;
        int currentLevel = 0;
        int totalWater = 0;
        while (i < j) {
            // if we find a bigger container, increase the max possible water
            // by the additional height * distance between them
            int newPossibleLevel = Math.min(a[i], a[j]);
            if (newPossibleLevel > currentLevel) {
                int increasedLevel = newPossibleLevel - currentLevel;
                int distanceBetweenThem = j - i - 1;
                totalWater += increasedLevel * distanceBetweenThem;
                currentLevel = newPossibleLevel; // update
            }
            
            // move the smaller building,
            // cos we need the bigger building, so that we can
            // find a bigger container later
            if (a[i] <= a[j]) {
                i++;
                // this is a building, so shouldnt have considered this as water
                // so reduce whatever area of this building is from the totalWater
                // we have considered all water only upto the `currentlevel`
                // so only reduce currentLevel height one time, if it's >= currentLevel 
                if (i >= j) break;
                int falseWater = Math.min(currentLevel, a[i]);
                totalWater -= falseWater;
            }
            else {
                j--;
                if (i >= j) break;
                int falseWater = Math.min(currentLevel, a[j]);
                totalWater -= falseWater;
            }
        }
        return totalWater;
    }
}