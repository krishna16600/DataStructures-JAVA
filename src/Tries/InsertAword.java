import java.util.*;

public class InsertAword {
	static TrieNode root;

	public InsertAword() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = word.charAt(0) - 'a'; // finding index of first char in the array
		TrieNode child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;

		}
		add(child, word.substring(1));
	}

	public void add(String word) {
		add(root, word);

	}

	private static boolean search(TrieNode root, String word) {
		if (word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child != null) {
			return search(child, word.substring(1));
		}
		return false;
	}

	public static boolean search(String word) {
		return search(root, word);
	}

	public void remove(String word) {
		remove(root, word);
	}

	private void remove(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminating = false;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null)
			return;

		remove(child, word.substring(1));
		// we can remove child only if it is non terminating and its number of children
		// are 0

		if (!child.isTerminating && child.childCount == 0) {
			root.children[childIndex] = null;
			child = null;
			root.childCount--;
		}

		/*
		 * if(!child.isTerminating) { int numChild = 0; for(int i=0;i<26;i++) {
		 * if(child.children[i]!=null) { numChild++; } } if(numChild==0) { //we can
		 * delete it root.children[childIndex] = null; child = null; root.childCount--;
		 * } }
		 */
	}

	private static int countWords(TrieNode root) {
		int result = 0;
		if (root.isTerminating)
			result++;

		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				result += countWords(root.children[i]);
			}
		}
		return result;
	}

	public static int countWords() {
		return countWords(root);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InsertAword q = new InsertAword();
		q.add("krishna");
		q.add("hello");
		q.add("search");
		q.add("kk");
		q.add("hahaha");
		q.add("shivani");
		System.out.println(q.countWords(root));
	}
}
