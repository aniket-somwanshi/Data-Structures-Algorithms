class Solution {
    int row[]={1,-1,0,0};
    int col[]={0,0,-1,1};
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid2.length;
        int m=grid2[0].length;
        ArrayList<ArrayList<pair>> res=new ArrayList<>();
        
        boolean visited[][]= new boolean[n][m];
		// dfs in grid2 and store connected cells of each connected cell
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1  && !visited[i][j]){
                    ArrayList<pair> list=new ArrayList<>();
                    dfs(grid2,i,j,visited,list);
                    res.add(list);
                }
            }
        }
		// check if it is 1 in grid1 or not
        int count=0;
        for(ArrayList<pair> a:res){
            boolean ok=true;
            for(int z=0;z<a.size();z++){
                pair p=a.get(z);
                if(grid1[p.x][p.y]!=1){
                    ok=false;
                    break;
                }
            }
            if(ok==true)count++;
        }
        
        return count;
    }
	// dfs function
    void dfs(int[][] grid2,int i,int j,boolean[][] visited,ArrayList<pair> list){
        if(i<0|| j<0 || i>=grid2.length || j>=grid2[0].length || grid2[i][j]==0 || visited[i][j])return;
        visited[i][j]=true;
        list.add(new pair(i,j));
        for(int p=0;p<4;p++){
            dfs(grid2,i+row[p],j+col[p],visited,list);
        }
    }
}class pair{
    int x;
    int y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}