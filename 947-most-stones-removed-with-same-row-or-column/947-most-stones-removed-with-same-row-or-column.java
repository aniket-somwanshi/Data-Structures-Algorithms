class Solution {
    public int removeStones(int[][] stones) {
	int n = stones.length; 
	if (n <= 1) return 0; 

	Map<int[], int[]> groups = new HashMap<>(); // maps child -> root

	// init by assigning itself as root to each node
	for (int[] stone : stones) groups.putIfAbsent(stone, stone); 

	// sort by row
	Arrays.sort(stones, (a,b)->(a[0] - b[0]));
	int[] curr, prev;
	for (int i = 1; i < n; i++) {
		curr = stones[i];
		prev = stones[i - 1];
		// union those in the same row
		if (curr[0] == prev[0]) union(groups, prev, curr);
	}

	// sort by col
	Arrays.sort(stones, (a,b)->(a[1] - b[1])); 
	for (int i = 1; i < n; i++) {
		curr = stones[i];
		prev = stones[i - 1];
		// union those in the same column
		if (curr[1] == prev[1]) union(groups, prev, curr); 
	}

	// count the number of roots = connected components
	Set<int[]> uniqueGroups = new HashSet<>();
	for (int[] child : groups.keySet()) {
		// note: update root one last time here in case some have not been updated
		uniqueGroups.add(get(groups, child));
	}

	return n - uniqueGroups.size(); 
}

private void union(Map<int[], int[]> groups, int[] a, int[] b) {
	int[] rootA = get(groups, a), rootB = get(groups, b); 
	
	// if same row, use the left one as root 
	if (rootA[0] == rootB[0]) { 
		if (rootA[1] > rootB[1]) groups.put(rootA, rootB);
		else if (rootA[1] < rootB[1]) groups.put(rootB, rootA); 
	} else if (rootA[0] < rootB[0]) {
		// if different rows, use the higher one 
		groups.put(rootB, rootA);
	} else {
		groups.put(rootA, rootB); 
	}
}

private int[] get(Map<int[], int[]> groups, int[] a) {
	// find overall root
	int[] root = a; 
	while (!Arrays.equals(root, groups.get(root))) {
		root = groups.get(root);
	}

	// point all the nodes along the way to overall root 
	int[] curr = a, next; 
	while (!Arrays.equals(root, curr)) {
		next = groups.get(curr);
		groups.put(curr, root); 
		curr = next; 
	}

	return root; 
}
}