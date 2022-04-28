class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        vector<char> curr;
        bool ans = false;
        vector<vector<int>> visited(board.size(),vector<int>(board[0].size(),0));
        for(int i = 0;i<board.size();++i){
            for(int j= 0 ; j < board[0].size();++j){
                if(board[i][j] == word[0]){
                    visited = vector<vector<int>>(board.size(),vector<int>(board[0].size(),0));
                    dfs(board,curr,ans,i,j,visited,0,word);
                    if(ans)
                        return ans;
                }
            }
        }
        return ans;
    }
    void dfs(vector<vector<char>>& board,vector<char>& curr,bool& ans,int i,int j,vector<vector<int>>& visited,int idx,string& word){
        if(ans)
            return;
        curr.push_back(board[i][j]);
        if(curr.size()==word.size()){
            ans = true;
            return;
        }
        if(idx >= word.size())
            return;
        
        visited[i][j]=1;
        //right
        if(j+1<board[0].size()&&board[i][j+1]==word[idx+1]&&!visited[i][j+1]){
            dfs(board,curr,ans,i,j+1,visited,idx+1,word);
        }
        //left
        if(j>0&&board[i][j-1]==word[idx+1]&&!visited[i][j-1]){
            dfs(board,curr,ans,i,j-1,visited,idx+1,word);
        }
        //top
        if(i>0&&board[i-1][j]==word[idx+1]&&!visited[i-1][j]){
            dfs(board,curr,ans,i-1,j,visited,idx+1,word);
        }
        //down
        if(i+1<board.size()&&board[i+1][j]==word[idx+1]&&!visited[i+1][j]){
            dfs(board,curr,ans,i+1,j,visited,idx+1,word);
        }
        visited[i][j]=0;
        curr.pop_back();
    }
};