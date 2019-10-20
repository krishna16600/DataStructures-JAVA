package binarySearchTree;

import java.lang.reflect.Array;
import java.util.*;

public class BinarySearchTreeUse {

	public static BinaryTreeNode<Integer> takeInput(Scanner sc) throws QueueEmptyException {
		System.out.println("Enter root data");
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		int rootData = sc.nextInt();
		if (rootData == -1)
			return null;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingNodes.dequeue();

			System.out.println("Enter left child data of " + front.data);
			int leftChild = sc.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> leftChildren = new BinaryTreeNode<Integer>(leftChild);
				front.left = leftChildren;
				pendingNodes.enqueue(leftChildren);
			}
			System.out.println("Enter right child data of " + front.data);
			int r = sc.nextInt();
			if (r != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(r);
				front.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;

	}

	public static void print(BinaryTreeNode<Integer> root) throws QueueEmptyException {
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			int n = pendingNodes.size();

			while (n > 0) {
				BinaryTreeNode<Integer> front = pendingNodes.dequeue();
				System.out.print(front.data + ": ");
				if (front.left != null) {
					System.out.print("L: " + front.left.data + ",");
					pendingNodes.enqueue(front.left);
				} else {
					System.out.print("R: -1,");
				}
				if (front.right != null) {
					System.out.println("R: " + front.right.data + ",");
					pendingNodes.enqueue(front.right);
				} else {
					System.out.println("R: " + "-1,");
				}
				n--;
			}

		}
	}

	public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root, int n) {
		if (root == null)
			return root;

		BinaryTreeNode<Integer> ans = null;
		if (root.data == n)
			return root;

		if (n < root.data)
			ans = searchInBST(root.left, n);

		if (n > root.data)
			ans = searchInBST(root.right, n);
		return ans;
	}

	public static void printInRange(BinaryTreeNode<Integer> root, int k1, int k2) // 20 50
	{
		if (root == null)
			return;

		if (k1 < root.data)
			printInRange(root.left, k1, k2);

		if (root.data >= k1 && root.data <= k2)
			System.out.println(root.data + " ");

		if (k2 > root.data)
			printInRange(root.right, k1, k2);
	}

	public static int maximum(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	}

	public static int minimum(BinaryTreeNode<Integer> root) {
		if (root == null)
			return Integer.MAX_VALUE;

		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null)
			return true;

		int leftMax = maximum(root.left);
		int rightMin = minimum(root.right);

		if (root.data <= leftMax)
			return false;

		if (root.data > rightMin)
			return false;

		boolean isLeftBst = isBST(root.left);
		boolean isRightBst = isBST(root.right);

		return isLeftBst && isLeftBst;

	}

	public static void Inorder(BinaryTreeNode<Character> root) {
		if (root == null)
			return;

		Inorder(root.left);
		System.out.print(root.data + " ");
		Inorder(root.right);

	}

	// Pair<boolean, Pair<min,max>>
	public static Pair<Boolean, Pair<Integer, Integer>> isBST1(BinaryTreeNode<Integer> root) {
		if (root == null) {
			Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
			output.first = true;
			output.second = new Pair<Integer, Integer>();
			output.second.first = Integer.MAX_VALUE;
			output.second.second = Integer.MIN_VALUE;
			return output;
		}

		Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBST1(root.left);
		Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBST1(root.right);

		int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
		int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));

		boolean isBST = (root.data > leftOutput.second.second) && (root.data <= rightOutput.second.first)
				&& leftOutput.first && rightOutput.first;
		// root.data should be greater than the largest value in the subtree
		// root data should be less than equal to the minimum value in the subtree
		// if left is bst and right is bst

		Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
		output.first = isBST;
		output.second = new Pair<Integer, Integer>();
		output.second.first = min;
		output.second.second = max;
		return output;

		/*
		 * time complexity => T(n) = 2T(n/2) + K => O(n) independent of height!
		 */
	}

	public static boolean isBST2(BinaryTreeNode<Integer> root,int min, int max)
	{
		if(root == null)
		{
			return true;
		}
		
		if(root.data < min || root.data > max)
			return false;
		
		boolean isLeftOk = isBST2(root.left , min , root.data- 1);
		boolean isRightOk = isBST2(root.right, root.data, max);
		
		return isLeftOk && isRightOk;
		
		//TC => O(n)
	}

	public static BinaryTreeNode<Integer> consTreeSortedArray(int[] arr, int SI, int EI) {
		if (SI > EI)
			return null;

		int rootData = (SI + EI) / 2;

		BinaryTreeNode<Integer> rootD = new BinaryTreeNode<Integer>(arr[rootData]);
		rootD.left = consTreeSortedArray(arr, SI, rootData - 1);
		rootD.right = consTreeSortedArray(arr, rootData + 1, EI);

		return rootD;
	}
	public static PairOfNodeElem BSTtoLL(BinaryTreeNode<Integer> root)
	{
			if(root == null)
			{
				PairOfNodeElem pair = new PairOfNodeElem();
				pair.head = null;
				pair.tail = null;
				return pair;
			}
			
			Node<Integer> newNode = new Node<Integer>(root.data);
			PairOfNodeElem leftTree = BSTtoLL(root.left);
			PairOfNodeElem rightTree = BSTtoLL(root.right);
			PairOfNodeElem newPair = new PairOfNodeElem();
			
			if(leftTree.head!=null)
			{
				newPair.head = leftTree.head;
				newPair.tail = leftTree.tail;
				newPair.tail.next = newNode;
				newPair.tail = newNode;
				if(rightTree.head == null)
					return newPair;
			}
			if(rightTree.head!=null && leftTree.head!=null)
			{
				newPair.tail.next = rightTree.head;
				newPair.tail = rightTree.tail;
				return newPair;
			}
			if(rightTree.head!=null && leftTree.head == null)
			{
				newPair.head = newNode;
				newNode.next = rightTree.head;
				newPair.tail = rightTree.tail;
				return newPair;
			}
			else
			{
				newPair.head = newNode;
				newPair.tail = newNode;
			}
			return newPair;
	}
	public static void printList(PairOfNodeElem pair)
	{
		Node<Integer> head = pair.head;
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data)
	{
		if(root == null)
			return null;
		
		if(root.data == data)
		{
			ArrayList<Integer> out = new ArrayList<Integer>();
			out.add(data);
			return out;
		}
		if(data > root.data)
		{
			ArrayList<Integer> out1 = findPath(root.right, data);
			if(out1!=null) {
			out1.add(root.data);
			return out1;
			}			
		}
		else {
			ArrayList<Integer> out2 = findPath(root.left, data);
			if(out2!=null) {
				out2.add(root.data);
			
			return out2;
			}
		}
		
		return null;
	}
	public static void createAndInsertDuplicateNodeAtEachNode(BinaryTreeNode<Integer> root)
	{
		if(root == null)
			return;
		
		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
		BinaryTreeNode<Integer> rootLeft = root.left;
		newNode.left = rootLeft;
		root.left = newNode;
		
		createAndInsertDuplicateNodeAtEachNode(rootLeft);
		createAndInsertDuplicateNodeAtEachNode(root.right);
		
	}
	
	public static int LowestCommonAncestor(BinaryTreeNode<Integer> root, int a ,int b)
	{
		BinaryTreeNode<Integer> node = LCA_Helper(root,a,b);
		
		if(node!=null)
			return node.data;
		else
			return -1;
	}
	public static BinaryTreeNode<Integer> LCA_Helper(BinaryTreeNode<Integer> root, int a, int b) {
		if(root == null)
			return null;
		
		if(root.data == a || root.data == b)
			return root;
		
		BinaryTreeNode<Integer> LCAofLST = LCA_Helper(root.left, a, b);
		BinaryTreeNode<Integer> LCAofRST = LCA_Helper(root.right, a, b);
		
		if(LCAofLST!=null && LCAofRST!=null)
			return root;
		
		if(LCAofLST!=null)
			return LCAofLST;
		
		return LCAofRST;
	}

	public static void main(String[] args) throws QueueEmptyException {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		System.out.println(LowestCommonAncestor(root, 2, 10));
		

	}

}
