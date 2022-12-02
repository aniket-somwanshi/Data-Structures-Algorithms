/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;
        
        Map<Node, Node> map = new HashMap<>();
        
        Node ogNode = head;
        while (ogNode != null) {
            if (!map.containsKey(ogNode)) {
                // put the newNode in map
                Node newNode = new Node(ogNode.val);
                map.put(ogNode, newNode);
            }
            Node newNode = map.get(ogNode);
            
            // process it's random node
            if (ogNode.random != null && !map.containsKey(ogNode.random)) {
                // put new random node in map
                Node newRandomNode = new Node(ogNode.random.val);
                map.put(ogNode.random, newRandomNode);
            }
            // assign random node
            if (ogNode.random != null) newNode.random = map.get(ogNode.random);
            
            // process it's next node
            if (ogNode.next != null && !map.containsKey(ogNode.next)) {
                Node newNextNode = new Node(ogNode.next.val);
                map.put(ogNode.next, newNextNode);
            }
            // assign next node
            if (ogNode.next != null) newNode.next = map.get(ogNode.next);
            
            // move forward 
            ogNode = ogNode.next;
        }
        
        return map.get(dummy.next);
    }
}