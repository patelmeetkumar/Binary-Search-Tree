/*
 * Name: Meetkumar Patel
 * CS 2400 Fall 2018 Project 3
 */



import java.util.Iterator;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class BST<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T>
{
	
	public BST()
	{
		super();
		
	} // end default constructor
	
	public BST(T rootEntry)
	{
		super();
		setRootNode(new BinaryNode<T>(rootEntry));
		
	} // end constructor
	
	public void setTree(T rootData)
	{
		throw new UnsupportedOperationException();
		
	} // end setTree
	
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
	{
		throw new UnsupportedOperationException();
		
	} // end setTree
	
	public T getEntry(T entry)
	{
		return findEntry(getRootNode(), entry);
		
	} // end getEntry
	
	private T findEntry(BinaryNodeInterface<T> rootNode, T entry)
	{
		T result = null;
	
		if (rootNode != null)
		{
			T rootEntry = rootNode.getData();
			
			if (entry.equals(rootEntry)) 
			{
				result = rootEntry;
			}
			else if (entry.compareTo(rootEntry) < 0) 
			{
				result = findEntry(rootNode.getLeftChild(), entry); // recursive call, go to left tree 
			}
			else 
			{
				result = findEntry(rootNode.getRightChild(), entry); // recursive call, go to right tree
			}
			
		}
		
		return result;
		
	} // end findEntry
	
	public boolean contains(T entry)
	{
		return getEntry(entry) != null; // if able to find, return true
		
	} // end contains
	
	public T add(T newEntry) 
	{
		T result = null;
		
		if (isEmpty()) 
		{
			setRootNode(new BinaryNode<T>(newEntry)); // empty tree -> make it root
		}
		else 
		{
			result = addEntry(getRootNode(), newEntry); // else add appropriately in BST
		}
		return result;
		
	} // end add

	private T addEntry(BinaryNodeInterface<T> rootNode, T newEntry) 
	{
		assert rootNode != null;
		T result = null;
		
		int comparison = newEntry.compareTo(rootNode.getData());
		
		if (comparison == 0) // add at root
		{
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}
		else if (comparison < 0) // add on left subtree appropriately in BST
		{
			if (rootNode.hasLeftChild()) {
				result = addEntry(rootNode.getLeftChild(), newEntry); // go down, and add as leaf
			}
			else 
			{
				rootNode.setLeftChild(new BinaryNode<T>(newEntry)); // no child, so direct add
			}
		}
		else 
		{
			assert comparison > 0; // add on right subtree appropriately in BST after assert
			
			if (rootNode.hasRightChild())
			{
				result = addEntry(rootNode.getRightChild(), newEntry); // go down, and add as leaf
			}
			else 
			{
				rootNode.setRightChild(new BinaryNode<T>(newEntry)); // no child, so direct add
			}
		}
		return result;
		
	} // end addEntry
	
	
	
	class ReturnObject {

		private T data;
		
		public ReturnObject(T data) {
			this.data = data;
		} // end constructor

		public T get() {

			return data;
		} // end get

		public void set(T rootData) {
			
			this.data = rootData;
		} // end set
		
		
		
	} // end ReturnObject
	
	
	
	public T remove(T entry) // remove a given entry from BST
	{
		ReturnObject oldEntry = new ReturnObject(null);
		BinaryNodeInterface<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
		
		setRootNode(newRoot);
		
		return oldEntry.get();
		
	} // end remove
	
	private BinaryNodeInterface<T> removeEntry(BinaryNodeInterface<T> rootNode, T entry, ReturnObject oldEntry) 
	{
		if (rootNode != null) 
		{
			T rootData = rootNode.getData();
			int comparison = entry.compareTo(rootData);
			
			if (comparison == 0) { // remove root
				oldEntry.set(rootData);
				rootNode = removeFromRoot(rootNode);
			}
			else if (comparison < 0) // remove from left sub-tree
			{
				BinaryNodeInterface<T> leftChild = rootNode.getLeftChild();
				BinaryNodeInterface<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry); // recursive call to remove
				rootNode.setLeftChild(subtreeRoot);
			}
			else // remove from right sub-tree
			{
				BinaryNodeInterface<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry)); // recursive call to remove
			}
		}
		return rootNode;
		
	} // end removeEntry
	
	private BinaryNodeInterface<T> removeFromRoot(BinaryNodeInterface<T> rootNode) 
	{
		if(rootNode.hasLeftChild() && rootNode.hasRightChild()) 
		{
			BinaryNodeInterface<T> leftSubtreeRoot = rootNode.getLeftChild();
			BinaryNodeInterface<T> largestNode = findLargest(leftSubtreeRoot);
			
			rootNode.setData(largestNode.getData());
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot)); //right-most in left sub-tree replaces root
		}
		else if (rootNode.hasRightChild())
		{
			rootNode = rootNode.getRightChild(); // rightChild replaces root because rootNode has only one child
		}
		else 
		{
			rootNode = rootNode.getLeftChild(); // leftChild replaces root because rootNode has only one child
		}
		
		return rootNode;
		
	} // end removeFromRoot
	
	private BinaryNodeInterface<T> findLargest(BinaryNodeInterface<T> rootNode) 
	{
		if (rootNode.hasRightChild()) 
		{
			rootNode = findLargest(rootNode.getRightChild()); // return the largest entry in the tree given
		}
		
		return rootNode;
		
	} // end findLargest
	
	private BinaryNodeInterface<T> removeLargest(BinaryNodeInterface<T> rootNode) 
	{
		if (rootNode.hasRightChild()) 
		{
			BinaryNodeInterface<T> rightChild = rootNode.getRightChild();
			BinaryNodeInterface<T> root = removeLargest(rightChild); // recursive call
			rootNode.setRightChild(root); 
		}
		else 
		{
			rootNode = rootNode.getLeftChild();
		}
		
		return rootNode;
		
	} // end removeLargest

	public T getPredecessor(T entry)
	{
		if(!contains(entry) || entry.compareTo(getRootNode().getLeftmostData()) == 0) // can't find the entry
			throw new NoSuchElementException();
		else
		{
			boolean found = false;
			T predecessor = null;
			T currentEntry = null;
			Iterator<T> inorder = getInorderIterator();
			while (!found && inorder.hasNext())
			{
				predecessor = currentEntry;
				currentEntry = inorder.next();
				if(entry.compareTo(currentEntry) == 0)
					found = true;
			}
			
			return predecessor; // return the predecessor
		}
		
	} // end getPredecessor

	public T getSuccessor(T entry)
	{
		if(!contains(entry) || entry.compareTo(getRootNode().getRightmostData()) == 0) // can't find the entry
			throw new NoSuchElementException();
		else
		{
			boolean found = false;
			T successor = null;
			T currentEntry = null;
			Iterator<T> inorder = getInorderIterator();
			while (!found && inorder.hasNext())
			{
				currentEntry = inorder.next();
				if(entry.compareTo(currentEntry) == 0)
				{
					found = true;
					successor = inorder.next();
				}
			}
			
			return successor; // return the successor
		}
		
	} // end getSuccessor
	
	public Iterator<T> getInorderIterator()
	{
	   return new InorderIterator();
	} // end getInorderIterator
	
	
	
	private class InorderIterator implements Iterator<T>
	{
	   private StackInterface<BinaryNode<T>> nodeStack;
	   private BinaryNodeInterface<T> currentNode;

	   public InorderIterator()
	   {
	      nodeStack = new LinkedStack<>();
	      currentNode = getRootNode();
	   } // end default constructor

	   public boolean hasNext() 
	   {
	      return !nodeStack.isEmpty() || (currentNode != null);
	   } // end hasNext

	   public T next()
	   {
	      BinaryNode<T> nextNode = null;

	      // Find leftmost node with no left child
	      while (currentNode != null)
	      {
	         nodeStack.push((BinaryNode<T>) currentNode);
	         currentNode = currentNode.getLeftChild();
	      } // end while

	      // Get leftmost node, then move to its right subtree
	      if (!nodeStack.isEmpty())
	      {
	         nextNode = nodeStack.pop();
	         assert nextNode != null; // Since nodeStack was not empty
	                                  // before the pop
	         currentNode = nextNode.getRightChild();
	      }
	      else 
	      {
	    	  throw new NoSuchElementException();
	      }

	      return nextNode.getData(); 
	   } // end next

	   public void remove()
	   {
	      throw new UnsupportedOperationException();
	   } // end remove
	   
	   
	   
	} // end InorderIterator
	
	
	
} // end BST
