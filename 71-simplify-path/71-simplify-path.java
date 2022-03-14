class Solution {
    	public String simplifyPath(String path) {
        // We want a stack representation to process directories, but when we will make path we wnat eleemtn to be popped in reverse order (from first) to not reverse the stack. So better to use Dequeue
        Deque<String> queue = new LinkedList();
        Set<String> notDirectory = new HashSet(Arrays.asList("..",".",""));
        String[] dirs = path.split("/");
        for(String dir: dirs){
            if(dir.equals("..") && !queue.isEmpty()) {
                queue.pop();
            }
            else if(!notDirectory.contains(dir)) queue.push(dir);
        }
        StringBuilder result = new StringBuilder();
        if(queue.isEmpty()) return "/";
        
        while(!queue.isEmpty()){
            result.append("/"+queue.removeLast());
            
            
        }
        return result.toString();
    
}}