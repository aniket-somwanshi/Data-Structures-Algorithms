class Solution {
    int[] freq;
    public int minNumberOfFrogs(String croakOfFrogs) {
        freq = new int[26];
        int activeFrogs = 0;
        int maxiActiveFrogsAtATime = 0;
        for (char c: croakOfFrogs.toCharArray()) {
            freq[c-'a']++;
            if (!isValid()) return -1;
            if (c == 'c') {
                activeFrogs++;
            }
            if (c == 'k') {
                activeFrogs--;
            }
            maxiActiveFrogsAtATime = Math.max(maxiActiveFrogsAtATime, activeFrogs);
        }
        return activeFrogs == 0 ? maxiActiveFrogsAtATime : -1;
    }
    
    private boolean isValid() {
        if (freq['c'-'a'] < freq['r'-'a']) return false;
        if (freq['r'-'a'] < freq['o'-'a']) return false;
        if (freq['o'-'a'] < freq['a'-'a']) return false;
        if (freq['a'-'a'] < freq['k'-'a']) return false;
        return true;
    }
}