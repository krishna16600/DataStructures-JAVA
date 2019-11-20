import java.util.*;

public class AutoComplete {
	static TrieNode root;

	public AutoComplete() {
		root = new TrieNode('\0');
	}

	public static void insertHelper(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		insertHelper(child, word.substring(1));
	}

	public static void insert(String word) {
		insertHelper(root, word);
	}

	private static boolean searchHelper(TrieNode root, String word) {
		if (word.length() == 0)
			return root.isTerminating;

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child != null)
			return searchHelper(child, word.substring(1));

		return false;

	}

	public static boolean search(String word) {
		return searchHelper(root, word);
	}

	private static TrieNode findWordHelper(TrieNode root, String word) {
		if (word.length() == 0) {
			return root;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child != null)
			return findWordHelper(child, word.substring(1));

		return null;
	}

	public static TrieNode findWord(String word) {
		return findWordHelper(root, word);
	}

	private static void allPossibleWords(TrieNode root, String word, String output) {
	
		if (root.isTerminating)
			System.out.println(word + output);
		for (int i = 0; i < root.children.length; i++) {
			if (root.children[i] != null) {
				String ans = output + root.children[i].data;
				allPossibleWords(root.children[i], word, ans);
			}
		}
	}

	public static void autoComplete(ArrayList<String> arr, String word)
	{
		for(String s: arr)
			insert(s);
		
		TrieNode r = findWord(word);
		if(r==null || r.childCount==0)
		{
			System.out.println("No such word exits");
			return;
		}
		allPossibleWords(r, word, "");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AutoComplete a = new AutoComplete();
		ArrayList<String> arr = new ArrayList<String>();
		System.out.println("enter limit of strings");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			arr.add(str);
		}

		System.out.println("enter a word to get suggestions");
		String s = sc.next();
		autoComplete(arr,s);
	}
}
