class Solution {
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    if (!set.contains(endWord)) return 0;

    
    Queue<String> q = new ArrayDeque<>();
    q.add(beginWord);
    set.remove(beginWord);
    
    int count = 1;
    while(q.size() > 0){
        int size = q.size();
        while(size-->0){             //BFS
            String rem = q.remove();
            
            
            char arr[] = rem.toCharArray();
            for(int i=0; i<arr.length; i++){
                char store = arr[i];           // storing character to be changed
                
                for(char ch  = 'a'; ch<='z'; ch++){
                    arr[i] = ch;
                    
                    String nextWord = new String(arr);
                    if(set.contains(nextWord)){
                        if(nextWord.equals(endWord))
                            return count + 1;
                        else 
                            q.add(nextWord);
                            set.remove(nextWord);
                    }
                }
                
                arr[i] = store;       // restoring char so that next character can be changed
            }
            
            
        }
        
        count++;
    }
    
    return 0;
}
}