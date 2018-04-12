// Frank Chen
// APCS2 pd2
// HW32 - Leon Leonwood Stack
// 2018-04-11

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE>
{
	// Instance Variable
	private LinkedList<PANCAKE> _stack;
	
	// Constructor
	public LLStack()
	{
		_stack = new LinkedList<PANCAKE>();
	}
	
	// Empty?
	public boolean isEmpty()
	{
		return _stack.size() == 0;
	}
	
	// Peek
	public PANCAKE peek()
	{
		PANCAKE value = null;
		if( _stack.size() == 0 )
		{
			return null;
		}
		value = _stack.get( _stack.size() - 1 );
		return value;
	}
	
	// Remove
	public PANCAKE pop()
	{
		PANCAKE value = null;
		if( _stack.size() == 0 )
		{
			return null;
		}
		value = _stack.removeLast();
		return value;
	}
	
	// Insert
	public void push( PANCAKE x )
	{
		_stack.add( x );
	}
	
	// Main Method
	public static void main( String[] args )
	{
		Stack cakes = new LLStack();

		System.out.print("\n");
		
		System.out.println("Pushing...");
		cakes.push("Conflicts");
		cakes.push("Merge");
		cakes.push("Hate");
		cakes.push("I");
		
			System.out.print("\n");
		
		System.out.println("Pushing Complete...");
		
			System.out.print("\n");
		
		System.out.println("Testing Peek...");
		System.out.println( cakes.peek() );
		
			System.out.print("\n");
			
		System.out.println("Testing Pop...");
		System.out.println( cakes.pop() );
		System.out.println( cakes.pop() );
		System.out.println( cakes.pop() );
		System.out.println( cakes.pop() );
	}//end main
	
} // end class