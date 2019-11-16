import java.util.*;
public class PatternMatching {
	static TrieNode root;
	public PatternMatching() {
		root = new TrieNode('\0');
	}
	
	private static void insert(TrieNode root,String word)
	{
		if(word.length()==0)
		{
			root.isTerminating = true;
			return;
		}
		
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child==null)
		{
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		insert(child,word.substring(1));
	}
	public static void insert(String word)
	{
		insert(root,word);
	}
	private static boolean search(TrieNode root,String word)
	{
		if(word.length()==0)
			return true;
		
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child!=null)
			return search(child,word.substring(1));
			
			return false;
	}
	public static boolean search(String word)
	{
		return search(root,word);
	}
	public static boolean searchPattern(ArrayList<String> input,String pattern)
	{
		for(int i = 0; i<input.size() ;i++)
		{
			String w = input.get(i);
			for(int j = 0; j<w.length(); j++)
			{
				insert(w.substring(j));
			}
		}
		return search(pattern);
	}
	public static void main(String[] args) {
		PatternMatching p = new PatternMatching();
		Scanner sc= new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		System.out.println("Enter number of strings");
		int n = sc.nextInt();
		System.out.println("Enter Strings");
		for(int i = 0 ;i<n;i++)
		{
			System.out.println("Enter String "+i);
			String word = sc.next();
			arr.add(word);
		}
		System.out.println("enter pattern to search");
		String pat = sc.next();
		
		System.out.println("Pattern matched: "+ searchPattern(arr,pat));
		System.out.println(p.search("kr"));
		
	}
}
