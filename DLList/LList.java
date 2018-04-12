// Frank Chen
// APCS2 pd2
// HW24 -- On the DLL
// 2018-03-25

public class LList<T> implements List<T> {
	
	// Instance Variables
	private DLLNode head;
	private DLLNode tail;
	private int size;
	
	// Constructor
	public LList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	// Boolean Add
	public boolean add( T x )
	{
		DLLNode temp = new DLLNode( tail, x, null );
		tail = temp;
		if( tail.getPrev() != null )
		{
			tail.getPrev().setNext( tail );
		}
		size += 1;
		return true;
	}
	
	// Void Add
	public void add( int index, T newVal )
	{
		DLLNode temp = head;
		for( int x = 0; x < index; x++ )
		{
			temp = temp.getNext();
		}
		DLLNode temp2 = temp.getNext();
		temp.setNext( new DLLNode( temp, newVal, temp2 ) );
		temp2.setPrev( temp.getNext() );
		size += 1;
	}
	
	// T Remove
	public T remove( int index )
	{
		T retStr;
		DLLNode temp = head;
		for( int y = 0; y <= index; y++ )
		{
			temp = temp.getNext();
		} // end for
		retStr = (T)temp.getCargo();
		if( temp.getNext() == null )
		{
			temp.getPrev().setNext( null );
		}
		else
		{
			temp.getPrev().setNext( temp.getNext() );
		} // end if else
		if( temp.getPrev() == null )
		{
			temp.getNext().setPrev( null );
		}
		else
		{
			temp.getNext().setPrev( temp.getPrev() );
		} // end if else
		size -= 1;
		return retStr;
	}
	
	// T Get
	public T get( int i )
	{
		if( i < 0 || i >= size() )
		{
			throw new IndexOutOfBoundsException();
		}
		T retStr;
		DLLNode temp = head;
		for( int z = 0; z < i; z++ )
		{
			temp = temp.getNext();
		}
		retStr = (T)temp.getCargo();
		return retStr;
	}
	
	// T Set
	public T set( int i, T x )
	{
		if( i < 0 || i >= size() )
		{
			throw new IndexOutOfBoundsException();
		}
		T retStr;
		DLLNode temp = head;
		for( int a = 0; a < i; a++ )
		{
			temp = temp.getNext();
		}
		retStr = (T)temp.getCargo(); // Store old cargo
		temp.setCargo( x ); // Replace old cargo
		return retStr;
	}
	
	// Int Size
	public int size()
	{
		return size;
	}
	
	// Override Inherited toT
    public String toString()
    {
		String retStr = "HEAD -> ";
		DLLNode temp = head;
		while( temp != null )
		{
			retStr += temp.getCargo() + " -> ";
			temp = temp.getNext();
		}
		retStr += " <- TAIL";
		return retStr;
    }
	
	// Main Method
	public static void main( String[] args )
	{
		LList test = new LList();
		
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
		
		test.add( "Here" );
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
		
		test.add( "Name" );
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
		
		test.add( "Your" );
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
		
		test.add( "Insert" );
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
		
		test.add( 3, "TEST" );
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
		
		test.remove( 4 );
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
	}
	
}
