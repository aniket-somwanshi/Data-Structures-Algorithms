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
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution T = new Solution();
            List<Integer> ans = T.merge(root1,root2);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
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
    
*/


class BSTIteratorInorder {
    Stack<Node> st = new Stack<>();
    public BSTIteratorInorder(Node root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
    
    public int peekNext() {
        if (st.isEmpty()) return -1;
        else return st.peek().data;
    }
    
    public int next() {
        if (st.isEmpty()) return -1;
        
        Node current = st.pop();
        
        int toReturn = current.data;
        
        // for right child, push all the left childs 
        current = current.right;
        while (current != null) {
            st.push(current);
            current = current.left;
        }
        
        return toReturn;
    }
}

class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> res = new ArrayList<>();
        
        BSTIteratorInorder itr1 = new BSTIteratorInorder(root1);
        BSTIteratorInorder itr2 = new BSTIteratorInorder(root2);
        
        while (itr1.peekNext() != -1 &&  itr2.peekNext() != -1) {
            if (itr1.peekNext() <= itr2.peekNext()) {
                res.add(itr1.next());
            }
            else {
                res.add(itr2.next());
            } 
        }
        
        while (itr1.peekNext() != -1) {
            
                res.add(itr1.next());
               
        }
        
        while (itr2.peekNext() != -1) {
            
                res.add(itr2.next());
       
        }
        
        return res;
    }
}
