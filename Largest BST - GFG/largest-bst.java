//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class State {
    int mini;
    int maxi;
    int numberOfNodes;
    boolean isValid;
    public State(int mini, int maxi, int numberOfNodes, boolean isValid) {
        this.mini = mini;
        this.maxi = maxi;
        this.numberOfNodes = numberOfNodes;
        this.isValid = isValid;
    }
    
    public String toString() {
        return String.valueOf(mini)+"-"+String.valueOf(maxi)+"-"+String.valueOf(numberOfNodes);
    }
}
class Solution{
    static int res = 1;
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        res = 1;
        getState(root);
        return res;
    }
    
    private static State getState(Node node) {
        if (node == null) {
            return new State(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        
        State leftState = getState(node.left);
        State rightState = getState(node.right);
        
        State currentState = new State(-1,-1,-1,false);
        
        if (node.data == 8) {
        // System.out.println(leftState);
        // System.out.println();
        // System.out.println(rightState);
        // System.out.println();
        }
        
        
        if (leftState.isValid && rightState.isValid && leftState.maxi < node.data && node.data < rightState.mini) {
            
            
            
            currentState.mini = Math.min(node.data, Math.min(leftState.mini, rightState.mini));
            currentState.maxi = Math.max(node.data, Math.max(leftState.maxi, rightState.maxi));
            
            res = Math.max(res, 1 + leftState.numberOfNodes + rightState.numberOfNodes);
            currentState.isValid = true;
            currentState.numberOfNodes = 1 + leftState.numberOfNodes + rightState.numberOfNodes;
            
            
        }
        else {
            currentState.mini = Math.min(currentState.mini, node.data);
            currentState.maxi = Math.max(currentState.maxi, node.data);

            currentState.numberOfNodes = 1 + leftState.numberOfNodes + rightState.numberOfNodes;
            currentState.isValid = false;
            
        }
        
        return currentState;
    }
    
}