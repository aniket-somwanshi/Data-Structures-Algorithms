class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 4) return res;
        int[] segment = new int[4]; // there are 4 segments. this stores current segment values
        int currentSegment = 0;
        int buildPointer = 0;
        recur(buildPointer, currentSegment, s, res, segment);
        return res;
    }
    
    private void recur(int buildPointer, int currentSegment, String s, List<String> res, int[] segment) {
        // base cases
        if (currentSegment == 4 && buildPointer == s.length()) {
            res.add(segment[0]+"."+segment[1]+"."+segment[2]+"."+segment[3]);
            return;
        }
        else if (currentSegment == 4 || buildPointer == s.length()) return;
        
        // valid integers for a segment can be of max len 3 (0-255)
        // check if len1 len2 len3 integers can be valid 
        for (int len = 1; len <= 3 && buildPointer + len <= s.length(); len++) {
            int candidate = Integer.parseInt(s.substring(buildPointer, buildPointer + len));
            // check if invalid
            if (candidate > 255 || len >=2 && s.charAt(buildPointer) == '0') {
                break;
            }
            segment[currentSegment] = candidate;
            recur(buildPointer + len, currentSegment + 1, s, res, segment);
            segment[currentSegment] = -1;
        }
    }
}