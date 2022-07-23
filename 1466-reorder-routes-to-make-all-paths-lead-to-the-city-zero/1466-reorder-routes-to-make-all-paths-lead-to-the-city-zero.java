class Solution {

class Node{
    int value;
    List<Integer> inDegree;
    List<Integer> outDegree;

    Node(int value,List<Integer> inDegree,List<Integer> outDegree){
        this.value=value;
        this.inDegree=inDegree;
        this.outDegree=outDegree;
    }

    public List<Integer> getInDegree() {
        return inDegree;
    }

    public List<Integer> getOutDegree() {
        return outDegree;
    }
}
public int minReorder(int n, int[][] connections) {
    boolean visited[]=new boolean[n];

    List<Node> adjList=new ArrayList<>();

    for(int i=0;i<n;i++){
        adjList.add(new Node(i,new ArrayList<>(),new ArrayList<>()));
    }
    for(int[] connection:connections){
        int u=connection[0];
        int v=connection[1];
        adjList.get(u).getOutDegree().add(v);
        adjList.get(v).getInDegree().add(u);
    }
    visited[0]=true;
    Stack<Integer> stack=new Stack<>();
    stack.push(0);
    int reorder=0;
    while (!stack.isEmpty()){
        int pop=stack.pop();

        for(Integer nbr:adjList.get(pop).getOutDegree()){
            if(!visited[nbr]) {

                reorder++;
                stack.push(nbr);
                visited[nbr]=true;
            }
        }
        for(Integer nbr:adjList.get(pop).getInDegree()){
                if(!visited[nbr]) {
                    stack.push(nbr);
                    visited[nbr] = true;
                }
            }

    }
    return reorder;

}
}

