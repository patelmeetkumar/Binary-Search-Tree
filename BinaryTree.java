/*
 * Name: Meetkumar Patel
 * CS 2400 Fall 2018 Project 3
 */



public class BinaryTree<T> implements BinaryTreeInterface<T> {
	
	private BinaryNodeInterface<T> root;

	public BinaryTree() 
	{
		root = null;
		
	} // end default constructor

	public BinaryTree(T rootData) 
	{
		root = new BinaryNode<T>(rootData);
		
	} // end constructor

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) 
	{
		privateSetTree(rootData, leftTree, rightTree);
		
	} // end constructor

	public void setTree(T rootData) 
	{
		root = new BinaryNode<T>(rootData);
		
	} // end setTree

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
	{
		privateSetTree(rootData, (BinaryTree<T>)leftTree,(BinaryTree<T>)rightTree);
		
	} // end setTree

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) 
	{
		root = new BinaryNode<T>(rootData);
		
		if ((leftTree != null) && (!leftTree.isEmpty())) 
		{
			root.setLeftChild(leftTree.root);
		}
		
		if ((rightTree != null) && (!rightTree.isEmpty())) 
		{
			if (rightTree != leftTree) 
			{
				root.setRightChild(rightTree.root);
			}
			else 
			{
				root.setRightChild(rightTree.root.copy());
			}
		}
		
		if ((leftTree != null) && (leftTree != this)) 
		{
			leftTree.clear();
		}
		
		if ((rightTree != null) && (rightTree != this)) 
		{
			rightTree.clear();
		}
		
	} // end privatSetTree

	public int getHeight()
	{
		return root.getHeight();
		
	} // end getHeight
	
	public int getNumberOfNodes()
	{
		return root.getNumberOfNodes();
		
	} // end getNumberOfNodes

	public T getRootData()
	{
		T rootData = null;
		
		if (root != null)
			rootData = root.getData();
	
		return rootData;
		
	} // end getRootData
	
	public boolean isEmpty()
	{
		return root == null;
		
	} // end isEmpty
	
	public void clear()
	{
		root = null;
		
	} // end clear
	
	protected void setRootData(T rootData)
	{
		root.setData(rootData);
		
	} // end setRootData
	
	protected void setRootNode(BinaryNodeInterface<T> rootNode)
	{
		root = rootNode;
		
	} // end setRootNode
	
	protected BinaryNodeInterface<T> getRootNode()
	{
		return root;
		
	} // end getRootNode
		
	public void preorderTraverse()
	{
		preorderTraverse(root);
		
	} // end public preorderTraverse
	
	private void preorderTraverse(BinaryNodeInterface<T> node)
	{
		if(node !=null)
		{
			System.out.print(node.getData() + " ");
			preorderTraverse(node.getLeftChild());
			preorderTraverse(node.getRightChild());
		}
		
	} // end private preorderTraverse
	
	public void inorderTraverse() 
	{
		inorderTraverse(root);
		
	} // end public inorderTraverse
	
	private void inorderTraverse(BinaryNodeInterface<T> node) 
	{
		if(node != null) 
		{
			inorderTraverse(node.getLeftChild());
			System.out.print(node.getData() + " ");
			inorderTraverse(node.getRightChild());
		}

	} // end private inorderTraverse
	
	public void postorderTraverse() 
	{
		postorderTraverse(root);
		
	} // end public postorderTraverse
	
	private void postorderTraverse(BinaryNodeInterface<T> node) 
	{
		if(node != null) 
		{
			postorderTraverse(node.getLeftChild());
			postorderTraverse(node.getRightChild());
			System.out.print(node.getData() + " ");
		}
		
	} // end private postorderTraverse
	
	
	
} // end BinaryTree
