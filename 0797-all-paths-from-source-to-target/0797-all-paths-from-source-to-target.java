class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
					
        path.add(0);
        dfsSearch(graph, 0, res, path);
					
        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }
    
    // O(2^N) O(N)
    // Correct approach but implementation error
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         int n = graph.length;
//         Map<Integer, LinkedList<LinkedList<Integer>>> map = new HashMap<>();
//         LinkedList<LinkedList<Integer>> res = getPathsToDestinationFrom(0, graph, graph.length, map);
//         List<List<Integer>> compatible = new LinkedList<>();
//         compatible.addAll(res);
//         return compatible;
//     }
    
//     private LinkedList<LinkedList<Integer>> getPathsToDestinationFrom(int node, int[][] graph, int n, Map<Integer, LinkedList<LinkedList<Integer>>> map) {
//         if (map.containsKey(node)) return map.get(node);
//         // if not already present, create list
//         LinkedList<LinkedList<Integer>> current = new LinkedList<>();
//         // if current node is the destination, only path is itself 
//         if (node == n-1) {
//             LinkedList<Integer> tmp = new LinkedList<>();
//             tmp.add(node);
//             current.add(tmp);
//             map.put(node, current);
//             return current;
//         }
        
//         for (int neighbor: graph[node]) {
//             LinkedList<LinkedList<Integer>> neighborsPaths = getPathsToDestinationFrom(neighbor, graph, n, map);
//             // add current node at front of this path
//             for (LinkedList<Integer> path: neighborsPaths) {
//                 path.addFirst(node);
//                 // add this new path to current node's pathToDest
//                 current.add(path);
//             }
//         }
//         // cache this result for later use
//         map.put(node, current);
//         return current;
//     }
}