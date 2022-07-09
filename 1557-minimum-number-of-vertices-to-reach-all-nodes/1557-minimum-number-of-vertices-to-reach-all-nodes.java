class Solution {
    List<Integer> list;
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        list=new ArrayList<>();
        
        boolean []visited=new boolean[n];
        int []parent=new int[n];
        
        for(int i=0;i<n;i++){
           parent[i]=i;
        }
        
        for(List<Integer> list:edges){
            int u=list.get(0);
            int v=list.get(1);
            
            if(visited[v]) continue;
            
            int p1=findParent(parent,u);
            int p2=findParent(parent,v);
            
            parent[p2]=p1;
            visited[v]=true;
        }
        
        for(int i=0;i<parent.length;i++){
            if(parent[i]==i) list.add(i);
        }
        
        return list;
    }
    
    public int findParent(int[] parent,int i){
        if(parent[i]==i) return i;
        
        return parent[i]=findParent(parent,parent[i]);
    }
}