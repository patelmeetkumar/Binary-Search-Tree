/*
 * Name: Meetkumar Patel
 * CS 2400 Fall 2018 Project 3
 */



/*
 * An interface for ADT Tree
 */

public interface TreeInterface<T> 
{
	public T getRootData();
	
	public int getHeight();
	
	public int getNumberOfNodes();
	
	public boolean isEmpty();
	
	public void clear();
	
} // end TreeInterface
