package binarySearchTree;

import java.util.Scanner;

public class BinarySearchTreeCBuildClass {
	public static BinaryTreeNode<Integer> root = null;

	public static void insert(int d) {
		root = insertData(d, root);
	}

	public static BinaryTreeNode<Integer> insertData(int data, BinaryTreeNode<Integer> root) {
		if (root == null) {
			BinaryTreeNode<Integer> rootData = new BinaryTreeNode<Integer>(data);
			return rootData;
		}
		if (data > root.data) {
			root.right = insertData(data, root.right);
		} else {
			root.left = insertData(data, root.left);
		}
		return root;
	}

	public static boolean search(int d) {
		return searchData(d, root);
	}

	public static boolean searchData(int data, BinaryTreeNode<Integer> root) {
		if (root == null)
			return false;

		if (root.data == data)
			return true;

		if (data > root.data)
			return searchData(data, root.right);
		else
			return searchData(data, root.left);

	}

	public static void delete(int d) {
		root = deleteData(d, root);
	}

	public static BinaryTreeNode<Integer> deleteData(int data, BinaryTreeNode<Integer> root)
	{
		if(root == null)
			return null;
		
		if(data > root.data) {
			root.right = deleteData(data , root.right);
			return root;
		}
			else if(data < root.data) {
			root.left = deleteData(data , root.left);
			return root;
			}
			else
			{
				if(root.right==null && root.left==null)
					return null;
				else if(root.right==null)
					return root.left;
				else if(root.left==null)
					return root.right;
				else
				{
					int min = (int) root.right.data;
					BinaryTreeNode<Integer> n = root.right;
					
					while(n.left!=null)
					{
						min = (int) n.left.data;
						n = n.left;
					}
					root.data = min;
					root.right = deleteData(data, root.right);
				}
			}
		return root;
			
	}

	public static void print()
	{
		printTree(root);
	}
	public static void printTree(BinaryTreeNode<Integer> root)
	{
			if(root == null)
				return;
			
			String ans = new String();
			
			ans+= root.data+": ";
			
			if(root.left!=null)
			{
				ans+= "L:" + root.left.data+", ";
			}
			if(root.right!=null)
			{
				ans+= "R:" + root.right.data+", ";
			}
					System.out.println(ans);
					printTree(root.left);
					printTree(root.right);
	}
	public static void main(String[] args) {
		BinarySearchTreeCBuildClass bst = new BinarySearchTreeCBuildClass();
		Scanner s = new Scanner(System.in);
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
				case 1 : 
					input = s.nextInt();
					bst.insert(input);
					break;
				case 2 : 
					input = s.nextInt();
					bst.delete(input);
					break;
				case 3 : 
					input = s.nextInt();
					System.out.println(bst.search(input));
					break;
				default :
					bst.print();
					return;
			}
	}
}
}
