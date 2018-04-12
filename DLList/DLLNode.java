/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

// Frank Chen
// APCS2 pd2
// HW24 -- On the DLL
// 2018-03-25
 
public class DLLNode<T>
{
    // Instance Variables
    private T _cargo;    //cargo may only be of type String
    private DLLNode<T> _nextNode, _prevNode; //pointers to next, prev DLLNodes

    // Constructor
    public DLLNode( DLLNode<T> prev, T current, DLLNode<T> next )
    {
		_prevNode = prev;
		_cargo = current;
		_nextNode = next;
    }

    // Accessors
    public DLLNode<T> getPrev()
    {
		return _prevNode;
    }
    public T getCargo()
    {
		return _cargo;
    }
    public DLLNode<T> getNext()
    {
		return _nextNode;
    }

    // Mutators
    public DLLNode<T> setPrev( DLLNode<T> newPrev )
    {
		DLLNode<T> oldPrev = getPrev();
		_prevNode = newPrev;
		return oldPrev;
    }
    public T setCargo( T newCargo )
	{
		T oldCargo = getCargo();
		_cargo = newCargo;
		return oldCargo;
	}
	public DLLNode<T> setNext( DLLNode<T> newNext )
	{
		DLLNode<T> oldNext = getNext();
		_nextNode = newNext;
		return oldNext;
	}
	
	// toString
	public String toString()
	{
		return _cargo.toString();
	}
	
	// Main Method
	public static void main( String[] args )
	{
		//Below is an exercise in creating a linked list...

		//Create a node
		DLLNode first = new DLLNode( null, "cat", null );

		//Create a new node after the first
		first.setNext( new DLLNode( first, "dog", null ) );

		//Create a third node after the second
		first.getNext().setNext( new DLLNode( first.getNext(), "cow", null ) );

		/* A naive list traversal, has side effects.... ??
		   while( first != null ) {
		   System.out.println( first );
		   first = first.getNext();
		   }
		*/

	    //Q: when head ptr moves to next node in list, what happens to the node it just left?
	    //A: Node is deleted, memory is made available

		//...so better: ?
		DLLNode temp = first;
		while( temp != null )
		{
			System.out.println( temp );
			temp = temp.getNext();
		}
	
    }//end main
	
}//end class DLLNode
