class Node {
    int countEnds; // how many strings end here
    int count; // count how many strings have this character
    Map<Character, Node> child; // child nodes

    public Node() {
        child = new HashMap<>();
    }
}

public class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }

    public void erase(String word) {
        if (!search(word)) return;

        Node current = root;
        int i = 0;
        while (i < word.length()) {
            current.count--;
            current = current.child.get(word.charAt(i));
            i++;
        }
        current.countEnds--;
    }

    public void insert(String word) {
        Node current = root;
        int i = 0;
        while (i < word.length()) {
            if (!current.child.containsKey(word.charAt(i))) {
                current.child.put(word.charAt(i), new Node());
            }
            current = current.child.get(word.charAt(i));
            current.count++;
            i++;
        }
        current.countEnds++;
    }

    public int countWordsEqualTo(String word) {
        Node current = root;
        int i = 0;
        while (i < word.length() && current.child.containsKey(word.charAt(i))) {
            current = current.child.get(word.charAt(i));
            i++;
        }
        if (i == word.length()) return current.countEnds;
        else return 0;
    }

    public int countWordsStartingWith(String word) {
        Node current = root;
        int i = 0;
        while (i < word.length() && current.child.containsKey(word.charAt(i))) {
            current = current.child.get(word.charAt(i));
            i++;
        }
        if (i == word.length()) return current.count;
        else return 0;
    }

    public boolean search(String word) {
        return countWordsEqualTo(word) > 0;
    }

    public boolean startsWith(String prefix) {
        return countWordsStartingWith(prefix) > 0;
    }

}
