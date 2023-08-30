// Time Complexity : insert: O(L), search: O(L), startsWith: O(L)
// Space Complexity : insert: O(L), search: O(1), startsWith: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class TrieNode {
    public TrieNode[] children;
    public boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // Array to store child nodes for each lowercase letter
        isEndOfWord = false; // Flag to mark the end of a word
    }
}

public class ImplementTrie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(); // Initialize the root node
    }

    public void insert(String word) {
        TrieNode node = root; // Start at the root
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Calculate the index for the current character
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // Create a new node if it doesn't exist
            }
            node = node.children[index]; // Move to the next node
        }
        node.isEndOfWord = true; // Mark the end of the inserted word
    }

    public boolean search(String word) {
        TrieNode node = root; // Start at the root
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Calculate the index for the current character
            if (node.children[index] == null) {
                return false; // If the character is not found, the word is not in the trie
            }
            node = node.children[index]; // Move to the next node
        }
        return node.isEndOfWord; // Check if the node marks the end of a word
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root; // Start at the root
        for (char c : prefix.toCharArray()) {
            int index = c - 'a'; // Calculate the index for the current character
            if (node.children[index] == null) {
                return false; // If the character is not found, the prefix is not in the trie
            }
            node = node.children[index]; // Move to the next node
        }
        return true; // All characters in the prefix are found in the trie
    }
}