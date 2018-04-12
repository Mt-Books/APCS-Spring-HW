// Frank Chen
// APCS2 pd2
// HW21b -- We Got a Little Ol' Convoy...
// 2018-03-19

public class LList implements List {
	
	//instance vars
	private LLNode cargo;
	private int size;
	
	//constructor
	public LList()
	{
		cargo = null;
		size = 0;
	}
	
	//boolean add
	public boolean add( String x )
	{
		LLNode temp = new LLNode( x, cargo );
		cargo = temp;
		size += 1;
		return true;
	}
	
	//string get
	public String get( int i )
	{
		String retStr = "";
		LLNode temp = cargo;
		for( int x = 0; x < i; x++ )
		{
			temp = temp.getNext();
		}
		retStr = temp.getCargo();
		return retStr;
	}
	
	//string set
	public String set( int i, String x )
	{
		String retStr = "";
		LLNode temp = cargo;
		for( int a = 0; a < i; a++ )
		{
			temp = temp.getNext();
		}
		retStr = temp.getCargo();
		return retStr;
	}
	
	//int size
	public int size()
	{
		return size;
	}
	
	// override inherited toString
    public String toString()
    {
		String retStr = "Cargo: ";
		LLNode temp = cargo;
		while( temp != null )
		{
			retStr += temp.getCargo() + " ";
			temp = temp.getNext();
		}
		return retStr;
    }
	
	//main method
	public static void main( String[] args )
	{
		LList test = new LList();
		
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
		
		test.add( "Awesome" );
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
		
		test.add( "Are" );
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
		
		test.add( "You" );
		System.out.println( test );
		System.out.println( "Size: " + test.size() );
	}
	
}