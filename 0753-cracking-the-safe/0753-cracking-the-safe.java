// O(k^n) O(k^n)
class Solution {
    int numberOfPasswords;
    int k; int n;
    public String crackSafe(int n, int k) {
        this.n = n; this.k = k;
        numberOfPasswords = (int)Math.pow(k, n);
        String start = "";
        for (int i = 0; i < n; i++) {
            start += String.valueOf(0);
        }
        Set<String> set = new HashSet<>();
        set.add(start);
        return f(start, set);
    }
    
    private String f(String current, Set<String> set) {
        if (set.size() == numberOfPasswords) {
            return current;
        }
        
        String smallestString = null;
        int smallestSize = Integer.MAX_VALUE;
        // explore
        for (int digit = 0; digit < k; digit++) {
            String temp = current + String.valueOf(digit);
            if (!set.contains(temp.substring(temp.length()-n))) {
                set.add(temp.substring(temp.length()-n));
                String res = f(temp, set);
                if (res != null) {
                    return res;
                }
                
               set.remove(temp.substring(temp.length()-n));
            }
        }
        
        return smallestString;
    }
}

class Pair {
    StringBuilder sb;
    Set<String> set;
    public Pair(StringBuilder sb, Set<String> set) {
        this.sb = sb;
        this.set = set;
    }
}

// BFS implementation mistake. correct logic
// class Solution {
//     public String crackSafe(int n, int k) {
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < n; i++) {
//             sb.append('0');
//         }
        
//         int sizeOfAllPasswords = (int)Math.pow(k, n);
        
//         Queue<Pair> q = new LinkedList<>();
//         Set<String> set = new HashSet<>();
//         set.add(sb.toString());
//         q.add(new Pair(sb, set));
        
//         int level = 1;
        
//         while (!q.isEmpty()) {
//             int size = q.size();
//             while (size-- > 0) {
//                 Pair current = q.poll();
//                 StringBuilder currentSb = current.sb;
//                 Set<String> currentSet = current.set;
                
//                 if (currentSet.size() == sizeOfAllPasswords) {
//                     return currentSb.toString();
//                 }
                
//                 for (int digit = 0; digit < k; digit++) {
//                     String temp = currentSb.toString();
//                      temp += String.valueOf(digit);
//                      temp = temp.substring(temp.length()-n);
//                     Set<String> possibleNextSet = new HashSet<>(currentSet);
//                     if (!currentSet.contains(temp)) {
//                         possibleNextSet.add(temp);
//                         // System.out.println(possibleNext);
//                         for (String gg: possibleNextSet) {System.out.println(gg);}
//                         System.out.println();
//                         q.add(new Pair(currentSb.append(String.valueOf(digit)), possibleNextSet));
//                     }
//                 }
                        
//             }
//             level++;
//         }
        
//         return "-1";
//     }
// }

// class Pair {
//     StringBuilder sb;
//     Set<String> set;
//     public Pair(StringBuilder sb, Set<String> set) {
//         this.sb = sb;
//         this.set = set;
//     }
// }