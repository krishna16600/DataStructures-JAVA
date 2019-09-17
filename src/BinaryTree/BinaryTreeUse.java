package binaryTree;

import java.util.*;
public class BinaryTreeUse {
	public static BinaryTreeNode<Integer> takeInput(Scanner sc)
	{
		int rootData;
		System.out.println("Enter root's data");
		rootData=sc.nextInt();
		
		if(rootData==-1)
			return null;
		
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		root.left=takeInput(sc);
		root.right=takeInput(sc);
		
		return root;
	}
	
	public static void print(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return;
		
		String toBePrinted=root.data+": ";
		if(root.left!=null)
			toBePrinted+="L: "+ root.left.data+",";
		
		if(root.right!=null)
			toBePrinted+="R: "+root.right.data+",";
		
		System.out.println(toBePrinted);
		
		print(root.left);
		print(root.right);
	
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(Scanner s) throws QueueEmptyException{
		Scanner sc=new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes=new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		System.out.println("enter root");
		int rootData=sc.nextInt();
		
		if(rootData==-1)
			return null;

		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty())
		{
			BinaryTreeNode<Integer> front=pendingNodes.dequeue();
			
			System.out.println("enter left child of "+ front.data);
			int leftChild=sc.nextInt();
			if(leftChild!=-1)
			{
				BinaryTreeNode<Integer> child=new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.left=child;		
			}
			
			System.out.println("enter right child of "+ front.data);
			int rightChild=sc.nextInt();
			if(rightChild!=-1)
			{
				BinaryTreeNode<Integer> child=new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right=child;
			}
		}
		
		return root;
		
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) throws QueueEmptyException {
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes=new QueueUsingLL<BinaryTreeNode<Integer>>();
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty()) {
			int n=pendingNodes.size();
			
			while(n>0)
			{
				BinaryTreeNode<Integer> front=pendingNodes.dequeue();
				System.out.print(front.data+": ");
				if(front.left!=null) {
					System.out.print("L: "+front.left.data+",");
				pendingNodes.enqueue(front.left);
			}
				else
				{
					System.out.print("L:" + "-1,");
				}
				if(front.right!=null) {
					System.out.println("R: "+front.right.data+",");
					pendingNodes.enqueue(front.right);
				}
				else {
					System.out.println("R: -1,");
				}
				n--;
			}
		
		}
		
		
	}
	
	public static int countNodes(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		
		int ans=1;
		ans+=countNodes(root.left);
		ans+=countNodes(root.right);
		return ans;
		
	}
	
	public static boolean checkNode(BinaryTreeNode<Integer> root,int x)
	{
		if(root==null)
			return false;
		
		if(root.data==x)
			return true;
		
		boolean ans=checkNode(root.left, x);
		boolean ans1=checkNode(root.right,x);
	return ans || ans1;
	}
	
	public static int height(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		int l=height(root.left);
		int r=height(root.right);
		
		return Math.max(l, r)+1;
		}
	 
	public static BinaryTreeNode<Integer> mirrorTree(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return null;
		
		BinaryTreeNode<Integer> temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		mirrorTree(root.left);
		mirrorTree(root.right);
		
		return root;
	}

	public static void printMirror(BinaryTreeNode<Integer> root)
	{
		QueueUsingLL<BinaryTreeNode<Integer>> primary=new QueueUsingLL<BinaryTreeNode<Integer>>();
		QueueUsingLL<BinaryTreeNode<Integer>> secondary=new QueueUsingLL<BinaryTreeNode<Integer>>();
		
		primary.enqueue(root);
		
		while(!primary.isEmpty()) {
			BinaryTreeNode<Integer> current=null;
			
			try {
				current=primary.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(current.data+" ");
			if(current.left!=null)
				secondary.enqueue(current.left);
			if(current.right != null){
				secondary.enqueue(current.right);
			}
			if(primary.isEmpty()){
				QueueUsingLL<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}
	
	public static int diameter(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		
		int option1=height(root.left)+height(root.right);
		int option2=diameter(root.left);
		int option3= diameter(root.right);
		
		return Math.max(option2,Math.max(option3,option1));
	}

	public static Pair<Integer,Integer> heightD(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			Pair<Integer,Integer> output=new Pair<Integer, Integer>();
			output.first=0;
			output.second=0;
			return output;
		}
		Pair<Integer, Integer> leftOp= heightD(root.left);
		Pair<Integer, Integer> rightOp= heightD(root.right);
		
		int height=1+ Math.max(leftOp.first, rightOp.first);
		int option1=leftOp.first + rightOp.first;
		int option2 = leftOp.second;
		int option3 = rightOp.second;
		
		int diameter = Math.max(option1, Math.max(option2, option3));
		
		Pair<Integer,Integer> output=new Pair<Integer, Integer>();
		output.first=height;
		output.second=diameter;
		
		return output;
		
	}
	
	public static void inorder(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	public static void preOrder(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void postOrder(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public static BinaryTreeNode<Integer> buildTreeHelper(int[] in,int[] pre,int inS,int inE,int preS,int preE)
	{
		if(inS>inE)
			return null;
		
		int rootData=pre[preS];
		int rootIndex=-1;
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		
		for(int i=inS;i<=inE;i++)
		{
			if(in[i]==rootData)
			{
				rootIndex=i;
				break;
			}
		}
		
		int leftInS=inS;
		int leftInE= rootIndex-1;
		int leftPreS=preS+1;
		int leftPreE= leftInE - leftInS + leftPreS;
		
		int rightIns=rootIndex+1;
		int rightInE=inE;
		int rightPreS=leftPreE+1;
		int rightPreE=preE;
		
		root.left=buildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);
		root.right=buildTreeHelper(in, pre, rightIns, rightInE, rightPreS, rightPreE);
	
		return root;
	}
	
	
	public static BinaryTreeNode<Integer> BuildTree(int[] in,int[] pre)
	{
		return buildTreeHelper(in,pre,0,in.length-1,0,pre.length-1);
	}
	
	
	public static BinaryTreeNode<Integer> BuildTreePostInHelper(int[] in,int[] post, int inS,int inE,int postS,int postE)
	{
		if(inS>inE)
			return null;
		int rootIndex=-1;
		int rootData = post[postE];
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
		for(int i=inS;i<=inE;i++)
		{
			if(in[i]==rootData)
			{
				rootIndex=i;
				break;
			}
		}
		
		int leftInS = inS;
		int leftInE = rootIndex-1;
		int leftPostS = postS;
		int leftPostE = leftInE - leftInS +leftPostS;
		
		int rightIns=rootIndex+1;
		int rightInE=inE;
		int rightPostS = leftPostE+1;
		int rightPostE = postE-1;
		
		root.left=BuildTreePostInHelper(in, post, leftInS, leftInE, leftPostS, leftPostE);
		root.right=BuildTreePostInHelper(in, post, rightIns, rightInE, rightPostS, rightPostE);
		
		return root;
		
	}
	
	public static BinaryTreeNode<Integer> BuildTreePostIn(int[] in,int[] post)
	{
		return BuildTreePostInHelper(in,post,0,in.length-1,0,post.length-1);
	}
	public static int sumOfAllNodes(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		
		int l=sumOfAllNodes(root.left);
		int r=sumOfAllNodes(root.right);
		
		return root.data+l+r;
	}
	
	public static void printLevelOrderTraversal(BinaryTreeNode<Integer> root) throws QueueEmptyException
	{
		QueueUsingLL<BinaryTreeNode<Integer>> q=new QueueUsingLL<BinaryTreeNode<Integer>>();
		q.enqueue(root);
		
		while(!q.isEmpty())
		{
			BinaryTreeNode<Integer> front=null;
			
			int n=q.size();
			
			for(int i=0;i<n;i++)
			{
				front=q.dequeue();
				System.out.print(front.data+" ");
				
				if(front.left!=null)
					q.enqueue(front.left);
				
				if(front.right!=null)
				{
					q.enqueue(front.right);
				}
				
			}
			System.out.println();
		}
		}
	
	public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return null;
		
		if(root.left==null && root.right==null)
		{
			root=null;
		}
		
		if(root!=null && root.left!=null)
			root.left = removeLeaf(root.left);
		
		
		if(root!=null && root.right!=null)
			root.right=removeLeaf(root.right);

	return root;
	}
	
	public static ArrayList<Node<BinaryTreeNode<Integer>>> levelLinkedList(BinaryTreeNode<Integer> root) throws QueueEmptyException
	{
		QueueUsingLL<BinaryTreeNode<Integer>> q = new QueueUsingLL<BinaryTreeNode<Integer>>();
		q.enqueue(root);
		ArrayList<Node<BinaryTreeNode<Integer>>> heads=new ArrayList<Node<BinaryTreeNode<Integer>>>();
		
		while(!q.isEmpty())
		{
			BinaryTreeNode<Integer> front=null;
			Node<BinaryTreeNode<Integer>> head=null;
			Node<BinaryTreeNode<Integer>> temp=null;
			
			int n=q.size();
			
			for(int i=0;i<n;i++)
			{
				front=q.dequeue();
				Node<BinaryTreeNode<Integer>> first = new Node<BinaryTreeNode<Integer>>(front);
				
				if(head==null)
				{
					head=first;
					temp=first;
				}
				else {
					temp.next=first;
					temp=temp.next;
				}
				
				if(front.left!=null)
					q.enqueue(front.left);
				
				if(front.right!=null)
					q.enqueue(front.right);
				
			}
			heads.add(head);
		}
		
		return heads;
	}
	
	public static void zigzag(BinaryTreeNode<Integer> root) throws QueueEmptyException
	{
		QueueUsingLL<BinaryTreeNode<Integer>> q=  new QueueUsingLL<BinaryTreeNode<Integer>>();
		q.enqueue(root);
		int count=1;
		while(!q.isEmpty())
		{
			BinaryTreeNode<Integer> front=null;
			String str = new String();
			
			int size=q.size();
			
			for(int i=0;i<size;i++)
			{
				front=q.dequeue();
				str+=front.data+" ";
				
				if(front.left!=null)
					q.enqueue(front.left);
				
				if(front.right!=null)
					q.enqueue(front.right);
				
			}
			
			if(count==1)
			{
				System.out.println(str);
				count--;
			}
			else {
				String[] words=str.split(" ");
				for(int i=words.length-1;i>=0;i--)
					System.out.print(words[i]+" ");
				
				System.out.println();
				count++;
			}
		}
		
	}
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		
		// Write your code here
        
         if(root==null)
             return ;
        
        if(root.left==null && root.right!=null)
            System.out.println(root.right.data);
        if(root.right==null && root.left!=null)
            System.out.println(root.left.data);
        
        printNodesWithoutSibling(root.left);
            printNodesWithoutSibling(root.right);
	}

	public static void main(String[] args) throws QueueEmptyException {
		Scanner sc=new Scanner(System.in);
		BinaryTreeNode<Integer> root=takeInputLevelWise(sc);
	//	printLevelWise(root);
	/*	System.out.println("Number of nodes are: "+ countNodes(root));
		System.out.println("enter a number to check if its present ");
		int num=sc.nextInt();
		System.out.println("number is present "+ checkNode(root, num));
		System.out.println("height of tree is "+ height(root));
		BinaryTreeNode<Integer> mirrorRoot=mirrorTree(root);
		System.out.println("mirror of the tree is");
		printMirror(mirrorRoot);
		System.out.println();
		System.out.println("The diameter of the tree is "+ diameter(root));
		System.out.println("Diameter of the tree in a better way is "+ heightD(root).second);
		System.out.println("Height of the tree in a better wat is "+ heightD(root).first);
		System.out.println("InOrder Traversal ");
		inorder(root);
		System.out.println();
		System.out.println("Pre Order Traversal ");
		preOrder(root);
		System.out.println();
		System.out.println("Post oder Traversal ");
		postOrder(root);
		System.out.println();
	//	construct a tree from inorder and preorder
		System.out.println("Enter inorder Array size");
		int inSize=sc.nextInt();
		int[] in=new int[inSize];
		System.out.println("Enter unique elements");
		for(int i=0;i<in.length;i++)
			in[i]=sc.nextInt();
		
		System.out.println("Enter Preorder Array size");
		int PreSize=sc.nextInt();
		int[] pre=new int[PreSize];
		System.out.println("Enter unique elements");
		for(int i=0;i<pre.length;i++)
			pre[i]=sc.nextInt();
		
		BinaryTreeNode<Integer> root2=BuildTree(in,pre); 
		printLevelWise(root2);
		
		//construct a tree from postorder and inorder
		System.out.println("Enter inorder Array size and PostOrder size array" );
		int inSize1=sc.nextInt();
		int PostSize=inSize1;
		int[] in1=new int[inSize1];
		System.out.println("Enter unique elements");
		for(int i=0;i<in1.length;i++)
			in1[i]=sc.nextInt();
		
		
		int[] post=new int[PostSize];
		System.out.println("Enter unique elements");
		for(int i=0;i<post.length;i++)
			post[i]=sc.nextInt();
		
	BinaryTreeNode<Integer> root1=BuildTreePostIn(in1, post);
		printLevelWise(root1);
	System.out.println();*/
	
				/*sum of all nodes*/
//	System.out.println("Sum of all Nodes is " + sumOfAllNodes(root));
			
		//Level wise printing
//	System.out.println("Level wise printing of tree");
//		printLevelOrderTraversal(root);
		
		//removing leaf nodes
	/*System.out.println("Removing leaf nodes");
		BinaryTreeNode<Integer> removedRoot = removeLeaf(root);
		printLevelOrderTraversal(removedRoot);*/
		
			//Level wise linked list and returning the arraylist having heads of all the 
		
	/*	ArrayList<Node<BinaryTreeNode<Integer>>> output= new ArrayList<Node<BinaryTreeNode<Integer>>>();
		output = levelLinkedList(root);
		
		for(Node<BinaryTreeNode<Integer>> head : output){
			Node<BinaryTreeNode<Integer>> temp = head;
			while(temp != null){
				System.out.print(temp.data.data + " ") ;
				temp = temp.next;
			}
			System.out.println();
		}*/
		
				//zigzag tree
	// zigzag(root);
		
			//nodes without sibling
		printNodesWithoutSibling(root);
		
		sc.close();
	}
}
