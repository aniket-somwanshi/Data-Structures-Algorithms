class Solution {
  public int minDominoRotations(int[] tops, int[] bottoms) {
    int[] rotations = new int[6];
    final int length = tops.length;
    for (int i = 1; i <= 6; i++) {
      int topRotationCount = 0;
      int bottomRotationCount = 0;
      for (int j = 0; j < length; j++) {
        if(!isPresent(i, tops[j],bottoms[j])) {
          bottomRotationCount = Integer.MAX_VALUE;
          topRotationCount = Integer.MAX_VALUE;
          break;
        }
        if (tops[j] == i && bottoms[j] != i) bottomRotationCount++;
        else if (tops[j] != i && bottoms[j] == i) topRotationCount++;
      }
      rotations[i-1] = Math.min(topRotationCount, bottomRotationCount);
    }
    Arrays.sort(rotations);
    return rotations[0] == Integer.MAX_VALUE ? -1 : rotations[0];
  }
  private boolean isPresent(int num, int top, int bottom) {
    return top == num || bottom == num;
  }
}
