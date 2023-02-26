// O(N*M) O(N*M) -- M = maxlength of a single word 
// Prefix map lookup
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new LinkedList<>();
        
        Set<String> set = new HashSet<>();
        
        Arrays.sort(folder, (a,b)->a.length()-b.length());
        
        for(String s: folder) {
            boolean isSubFolder = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '/') {
                    // we have found a prefix path
                    // see if this path is already present in set
                    if (set.contains(sb.toString())) {
                        isSubFolder = true;
                        break;
                    }
                    sb.append(s.charAt(i)); // '/'
                }   
                else {
                    sb.append(s.charAt(i));
                }
            }
            if (!isSubFolder) {
                res.add(s);
                set.add(s);
            }
        }
        
        return res;
    }
}