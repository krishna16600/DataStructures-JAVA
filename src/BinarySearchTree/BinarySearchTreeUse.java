package binarySearchTree;
import java.util.*;
public class BinarySearchTreeUse {

	public static BinaryTreeNode<Integer> takeInput(Scanner sc) throws QueueEmptyException
	{
		System.out.println("Enter root data");
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes =new QueueUsingLL<BinaryTreeNode<Integer>>();
		int rootData= sc.nextInt();
		if(rootData == -1)
			return null;
		
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty())
		{
			BinaryTreeNode<Integer> front = pendingNodes.dequeue();
			
			System.out.println("Enter left child data of " +front.data);
			int leftChild=sc.nextInt();
			if(leftChild!= -1)
			{
				BinaryTreeNode<Integer> leftChildren = new BinaryTreeNode<Integer>(leftChild);
				front.left= leftChildren;
				pendingNodes.enqueue(leftChildren);
			}
			System.out.println("Enter right child data of "+front.data);
			int r=sc.nextInt();
			if(r!=-1)
			{
				BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<Integer>(r);
				front.right= rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
			
	}
	
	public static void print(BinaryTreeNode<Integer> root) throws QueueEmptyException
	{
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		pendingNodes.enqueue(root);
		
		while(!pendingNodes.isEmpty())
		{
			int n=pendingNodes.size();
			
			while(n>0)
			{
				BinaryTreeNode<Integer> front= pendingNodes.dequeue();
				System.out.print(front.data+": ");
				if(front.left!=null)
				{
					System.out.print("L: "+front.left.data+",");
					pendingNodes.enqueue(front.left);
				}
				else {
					System.out.print("R: -1,");
				}
				if(front.right!=null)
				{
					System.out.println("R: "+front.right.data+",");
					pendingNodes.enqueue(front.right);
				}
				else {
					System.out.println("R: "+"-1,");
				}
				n--;
			}
			
			
		}
	}
	
	public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root, int n)
	{
		if(root==null)
			return root;
		
		BinaryTreeNode<Integer> ans=null;
		if(root.data == n)
			return root;
		
		if(n < root.data)
			ans = searchInBST(root.left, n);
		
		if(n > root.data)
			ans = searchInBST(root.right, n);
		return ans;
	}
	public static void printInRange(BinaryTreeNode<Integer> root,int k1,int k2) //20 50
	{
		if(root==null)
			return;
		
		if(k1 < root.data)
			printInRange(root.left, k1, k2);
	
		if(root.data >=k1 && root.data <=k2)
			System.out.println(root.data+" ");
		
		if(k2 > root.data)
			printInRange(root.right, k1, k2);
	}
	public static int maximum(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	} 
	public static int minimum(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return Integer.MAX_VALUE;
		
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}
	public static boolean isBST(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return true;
		
		int leftMax= maximum(root.left);
		int rightMin= minimum(root.right);
		
		if(root.data <= leftMax)
			return false;
		
		if(root.data > rightMin)
			return false;
		
		boolean isLeftBst= isBST(root.left);
		boolean isRightBst= isBST(root.right);
		
		return isLeftBst&&isLeftBst;
		
	}
	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root= takeInput(s);
	/*	print(root);
		System.out.println("enter a number you want to search, if found number will be printed");
		int n=s.nextInt();
		BinaryTreeNode<Integer> search = searchInBST(root, n);
		if(search!=null)
			System.out.println(search.data);
		else
			System.out.println("not found");
		
		System.out.println("enter min range and max range");
		int k1=s.nextInt();
		int k2=s.nextInt();
		printInRange(root, k1, k2);*/
		System.out.println(isBST(root));

	}

}
