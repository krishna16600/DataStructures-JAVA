import java.util.*;
public class TreeUse {
	static class MaxNodePair<T>{
		TreeNode<T> node;
		int sum;
	}
	public static TreeNode<Integer> takeInput(Scanner sc){
		int n;
		System.out.println("Enter next node data");
		n=sc.nextInt(); //root data
		TreeNode<Integer> root=new TreeNode<Integer>(n);
		System.out.println("Enter number of children for "+n);
		int childCount=sc.nextInt();
		for(int i=0;i<childCount;i++)
		{
			TreeNode<Integer> child=takeInput(sc);
			root.children.add(child);
		}
	return root;
	}
	
	public static void print(TreeNode<Integer> root)
	{
		String s=root.data+": ";
		for(int i=0;i<root.children.size();i++)
		{
			s=s+root.children.get(i).data+",";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++)
			print(root.children.get(i));
	}
	public static void printLevelWise(TreeNode<Integer> root)
	{
		 QueueUsingLL <TreeNode<Integer>> q=new QueueUsingLL<TreeNode<Integer>>();
         q.enqueue(root);
        //System.out.println(root.data);
           while(!q.isEmpty())
           {
               	try {
               int n=q.size();
               
               while(n>0)
               {
                 TreeNode<Integer> p=q.dequeue();
                   System.out.print(p.data+" ");
                   	
                   for(int i=0;i<p.children.size();i++)
                   {
                       q.enqueue(p.children.get(i));
                   }
                   n--;
               }
             }
                    catch (QueueEmptyException e) {
				// Shouldn't come here
				//return null;
			}
                 System.out.println();
           }
	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData=sc.nextInt();
		QueueUsingLL<TreeNode<Integer>> pendingNodes=new QueueUsingLL<>();
		TreeNode<Integer> root=new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty())
		{
			try {
				TreeNode<Integer> frontNode=pendingNodes.dequeue();
				System.out.println("Enter number of children for "+ frontNode.data);
				int numChildren=sc.nextInt();
				for(int i=0;i<numChildren;i++)
				{
					System.out.println("Enter "+(i+1)+"th child of "+frontNode.data);
					int child=sc.nextInt();
					TreeNode<Integer> childNode=new TreeNode<Integer>(child);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				return null;
				//shouldn't come here in try catch
			}
		}
		return root;
	}

	public static int numOfNodes(TreeNode<Integer> root)
	{
		int count=1;
		for(int i=0;i<root.children.size();i++)
		{
			count+=numOfNodes(root.children.get(i));
		}
		return count;
	}
	public static int sumOfNodes(TreeNode<Integer> root)
	{
		int sum=root.data;
		for(int i=0;i<root.children.size();i++)
		{
			sum+=sumOfNodes(root.children.get(i));
		}
		return sum;
	}
	public static int height(TreeNode<Integer> root)
{
	int max=0;
	for(int i=0;i<root.children.size();i++)
	{
		int h=height(root.children.get(i));
		if(h>max)
			max=h;
	}
	return max+1;
}
	public static void printAtDepthK(TreeNode<Integer>root, int k)
	{
		if(k<0)
			return;
		
		if(k==0)
			System.out.println("elements at depth "+root.data);
		
		for(int i=0;i<root.children.size();i++)
				printAtDepthK(root.children.get(i), k-1);
	}
	public static int countLeafNodes(TreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		
		if(root.children.size()==0)
			return 1;
		
		int count=0;
		for(int i=0;i<root.children.size();i++)
			count+=countLeafNodes(root.children.get(i));
		return count;
	}
	public static void preOrder(TreeNode<Integer> root)
	{
		if(root==null)
			return;
		
		System.out.print(root.data + " ");
		for(int i=0;i<root.children.size();i++)
			preOrder(root.children.get(i));
	}
	public static void postOrder(TreeNode<Integer> root)
	{
		if(root==null)
			return;
		
		for(int i=0;i<root.children.size();i++)
		{
			postOrder(root.children.get(i));
		}
		System.out.print(root.data+" ");
	}
	public static boolean checkIfContains(TreeNode<Integer> root,int x)

	{
		if(root==null)
			return false;
		
		if(root.data==x)
			return true;
		
		for(int i=0;i<root.children.size();i++)
			if(checkIfContains(root.children.get(i), x))
				return true;
		
		return false;
		
	}
	public static int numOfNodesGreaterThanX(TreeNode<Integer> root,int x)
	{
		int count=0;
		
		if(root.data>x)
			count++;
		
		for(int i=0;i<root.children.size();i++)
		{
			count+=numOfNodesGreaterThanX(root.children.get(i), x);
		}
		return count;
	}
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root)
	{
		return maxSumMaxNodeHelper(root).node;
	}
	
	public static MaxNodePair<Integer> maxSumMaxNodeHelper(TreeNode<Integer> root)
	{
		if(root==null)
		{
			MaxNodePair<Integer> pair=new MaxNodePair<Integer>();
			pair.node=null;
			pair.sum=Integer.MIN_VALUE;
			return pair;
		}
		
		int sum=root.data;
		
		for(TreeNode<Integer> child: root.children)
			sum+=child.data;
		
		MaxNodePair<Integer> ans=new MaxNodePair<Integer>();
		ans.node=root;
		ans.sum=sum;
		
		for(TreeNode<Integer> child: root.children)
		{
			MaxNodePair<Integer> childAns=maxSumMaxNodeHelper(child);
			if(childAns.sum > ans.sum)
				ans=childAns;
		}
		return ans;
	}
	public static boolean checkTrees(TreeNode<Integer> t1, TreeNode<Integer> t2)
	{
	 QueueUsingLL<TreeNode<Integer>> q=new QueueUsingLL<TreeNode<Integer>>();
	 QueueUsingLL<TreeNode<Integer>> q1=new QueueUsingLL<TreeNode<Integer>>();
	 q.enqueue(t1);
	 q1.enqueue(t2);
	 
	 while(!q.isEmpty())
	 {
		 int n=q.size();
		 
		 for(int k=0;k<n;k++)
		 {
			 try {
				TreeNode<Integer> p=q.dequeue();
				TreeNode<Integer> p1=q1.dequeue();
				
				if(p.data!=p1.data)
					return false;
				
			for(int i=0;i<p.children.size();i++)
			{
				q.enqueue(p.children.get(i));
				q1.enqueue(p1.children.get(i));
			}
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
	 return true;
	}
	public static TreeNode<Integer> nextLargerNode(TreeNode<Integer> root,int n)
	{
		if(root==null)
			return null;
		
		TreeNode<Integer> nextLargerN=null;
		
		if(root.data > n)
			nextLargerN=root;
		
		for(TreeNode<Integer> child: root.children)
		{
			TreeNode<Integer> nextLargerInChild=nextLargerNode(child, n);
			if(nextLargerInChild!=null)
			{
				if(nextLargerN==null || nextLargerN.data > nextLargerInChild.data )
					nextLargerN=nextLargerInChild;
			}
			
		}
		return nextLargerN;
	}
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root)
	{
		Queue<TreeNode<Integer>> q1=new LinkedList<TreeNode<Integer>>();
		ArrayList<Integer> q=new ArrayList<Integer>();
		
		q1.add(root);
		q.add(root.data);
		
		while(q1.size()!=0)
		{
			root=q1.remove();
			
			for(int i=0;i<root.children.size();i++)
			{
				q1.add(root.children.get(i));
				q.add(root.children.get(i).data);
			}
		}
		Collections.sort(q);
		
		int max=q.get(q.size()-1);
		System.out.println(max);
		for(int j=q.size()-1;j>=0;j--)
		{
			if(max!=q.get(j))
				return new TreeNode<Integer>(q.get(j));
		}
		return null;
	}
	public static TreeNode<Integer> replaceNodeWithDepth(TreeNode<Integer> root)
	{
		if(root==null)
			return null;
		
			return replaceNodeWithDepthHelper(root,0);
	}
	
	public static TreeNode<Integer> replaceNodeWithDepthHelper(TreeNode<Integer> root,int depth)
	{
		root.data=depth;
		
			for(int i=0;i<root.children.size();i++)
				replaceNodeWithDepthHelper(root.children.get(i),depth+1);
		
	return root;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	TreeNode<Integer> root=takeInputLevelWise();
	printLevelWise(root);
	System.out.println("num of nodes in the given tree is "+ numOfNodes(root));
	System.out.println("sum of all nodes is "+sumOfNodes(root));
	System.out.println("The height of the given tree(in level) is "+ height(root));
	//printAtDepthK(root,3);
	System.out.println("No. of leaf nodes: "+countLeafNodes(root));
	System.out.println("Tree Traversal In PreOrder");
	preOrder(root);
	System.out.println();
	System.out.println("Tree Traversal in Post Order");
	postOrder(root);
	System.out.println();
	System.out.println("Enter a number you want to check if present or not");
	int n=sc.nextInt();
	System.out.println(checkIfContains(root, n));
	System.out.println("Enter a number to check how many numbers in a tree are greater than the number");
	int y=sc.nextInt();
	System.out.println("Num of nodes greather than x is "+numOfNodesGreaterThanX(root, y));
	System.out.println("Node having Max Sum is "+maxSumNode(root).data);
	System.out.println("Both the trees are equal? "+checkTrees(root, root));
	System.out.println("Enter a num to find its next Largest ");
	int z=sc.nextInt();
	System.out.println("Next largest element is "+ nextLargerNode(root, z).data);
	System.out.println("Second Largest element is "+ findSecondLargest(root).data);
	
	TreeNode<Integer> root1=replaceNodeWithDepth(root);
	System.out.println("Replaced all nodes with their depth values");
	printLevelWise(root1);
	}
}
