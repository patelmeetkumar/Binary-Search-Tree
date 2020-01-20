/*
 * Name: Meetkumar Patel
 * CS 2400 Fall 2018 Project 3
 */



/*
 * An interface for the Binary Tree
 */

public interface BinaryTreeInterface<T> extends TreeInterface<T>
{
	/**
	 * Sets this binary tree to a new one-node binary tree.
	 * @param rootData an object that is the data in the new tree root
	 */
	public void setTree(T rootData);

	/**
	 * Sets this binary tree to a new binary tree.
	 * 
	 * @param rootData  an object that is the data in the new tree root
	 * @param leftTree  the left subtree of the new tree
	 * @param rightTree the right subtree of the new tree
	 */
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
	
} // end BinaryTreeInterface