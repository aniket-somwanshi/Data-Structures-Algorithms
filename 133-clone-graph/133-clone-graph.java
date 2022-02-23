/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Boolean> visited = new HashMap<>();
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, visited, map);
    }
    
    private Node dfs(Node node, Map<Node, Boolean> visited, Map<Node, Node> map) {
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        visited.put(node, true);
        for (Node neighbor: node.neighbors) {
            if (visited.containsKey(neighbor) == false || visited.get(neighbor) == false) {
                dfs(neighbor, visited, map);
            }
            newNode.neighbors.add(map.get(neighbor));
        }
        return newNode;
    }
}
// class Solution {
//     public Node cloneGraph(Node node) {
//         if (node == null) return null;
//         Map<Node, Node> map = new HashMap<>();
//         return buildNew(node, map);
//     }
    
//     private Node buildNew(Node node, Map<Node, Node> map) {
//         if (node == null) return null; 
//         if (map.containsKey(node)) return map.get(node);
//         Node copy_node = new Node(node.val);
//         map.put(node, copy_node);
        
//         for (Node neighbor: node.neighbors) {
//             copy_node.neighbors.add(buildNew(neighbor, map));
//         }
//         return copy_node;
//     }
// }