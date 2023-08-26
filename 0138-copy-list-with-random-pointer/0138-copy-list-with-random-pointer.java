// O(N) O(1)
class Solution {
    public Node copyRandomList(Node head) {
        Node ogNode = new Node(-1);
        ogNode.next = head;
        
        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(-1);
        
        while (ogNode != null) {
            if (ogNode.next != null && !map.containsKey(ogNode.next)) {
                map.put(ogNode.next, new Node(ogNode.next.val));
            }
            newNode.next = map.get(ogNode.next);
            
            if (ogNode.random != null && !map.containsKey(ogNode.random)) {
                map.put(ogNode.random, new Node(ogNode.random.val));
            }
            newNode.random = map.get(ogNode.random);
            
            newNode = newNode.next;
            ogNode = ogNode.next;
        }
                
        return map.get(head);
    }
}