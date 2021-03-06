/*
 * Name: Meetkumar Patel
 * CS 2400 Fall 2018 Project 3
 */



/*
 * An interface for the Binary Node.
 */

public interface BinaryNodeInterface<T> 
{
	/**
	 * Retrieves the data portion of this node.
	 * @return the object in the data portion of the node
	 */
	public T getData();

	/**
	 * Sets the data portion of this node.
	 * @param newData the data object
	 */
	public void setData(T newData);

	/**
	 * Retrieves the left child of this node.
	 * @return the node that is this node left child
	 */
	public BinaryNodeInterface<T> getLeftChild();

	/**
	 * Retrieves the right child of this node.
	 * @return the node that is this node right child
	 */
	public BinaryNodeInterface<T> getRightChild();

	/**
	 * Sets this node left child to a given node.
	 * @param leftChild a node that will be the left child
	 */
	public void setLeftChild(BinaryNodeInterface<T> leftChild);

	/**
	 * Sets this node right child to a given node.
	 * @param rightChild a node that will be the right child
	 */
	public void setRightChild(BinaryNodeInterface<T> rightChild);

	/**
	 * Detects whether this node has a left child.
	 * @return true if the node has a left child
	 */
	public boolean hasLeftChild();

	/**
	 * Detects whether this node has a right child.
	 * @return true if the node has a right child
	 */
	public boolean hasRightChild();

	/**
	 * Detects whether this node is a leaf.
	 * @return true if the node is a leaf
	 */
	public boolean isLeaf();

	/**
	 * Counts the nodes in the subtree rooted at this node.
	 * @return the number of nodes in the subtree rooted at this node
	 */
	public int getNumberOfNodes();

	/**
	 * Computes the height of the subtree rooted at this node.
	 * @return the height of the subtree rooted at this node
	 */
	public int getHeight();

	/**
	 * Copies the subtree rooted at this node.
	 * @return the root of a copy of the subtree rooted at this node
	 */
	public BinaryNodeInterface<T> copy();

	/**
	 * retrieves the very left most data
	 * @return the very left most data 
	 */
	public T getLeftmostData();

	/**
	 * retrieves the very right most data
	 * @return the very right most data 
	 */
	public T getRightmostData();
	
	
	
} // end BinaryNodeInterface
