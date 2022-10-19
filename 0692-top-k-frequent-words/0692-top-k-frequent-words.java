class Solution {
    class WordFreq {
        public String word;
        public int count;
        WordFreq(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> countMap = new HashMap<>();
        
        for (String word : words) {
            int count = countMap.getOrDefault(word, 0);
            count++;
            countMap.put(word, count);
        }

        PriorityQueue<WordFreq> minHeap = new PriorityQueue<>(
            (a,b) ->  {
                if (a.count != b.count) {
                    return a.count - b.count;
                }
                
                return b.word.compareTo(a.word);});

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            minHeap.offer(new WordFreq(entry.getKey(), entry.getValue()));

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            WordFreq wordFreq = minHeap.poll();
            result.add(wordFreq.word);
        }

        Collections.reverse(result);

        return result;
    }
}