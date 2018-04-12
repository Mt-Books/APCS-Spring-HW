/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/

// Frank Chen
// APCS2 pd2
// HW31 -- Stack: What Is It Good For?
// 2018-04-10

public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
	int size = s.length();
	Latkes t = new Latkes( size );
	String retStr = "";
	
	// Push each letter in string
	for( int i = 0; i < size; i++ )
	{
		t.push( s.substring( i, i + 1 ) );
	}
	
	// Add every pop to retStr
	for( int x = 0; x < size; x++ )
	{
		retStr = retStr + t.pop();
	}
	
	return retStr;
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s )
  {
	int size = s.length();
	
	// Default base case
	if( size == 0 )
	{
		return true;
	}
	
	Latkes t = new Latkes( size );
	char a = s.charAt( 0 );
	char b = s.charAt( size - 1 );
	
	// Other base cases
	if( a == '}' || a == ']' || a == ')' ||
		b == '{' || b == '[' || b == '(' )
	{
		return false;
	}
	
	for( int i = 0; i < size; i++ )
	{
		char x = s.charAt( i );
		if( x == '{' || x == '[' || x == '(' )
		{
			t.push( "" + x );
		}
		else
		{
			char next = ( "" + t.peek() ).charAt( 0 );
			if( (x == '}' && next == '[' ) ||
				(x == '}' && next == '(' ) ||
				(x == ']' && next == '{' ) ||
				(x == ']' && next == '(' ) ||
				(x == ')' && next == '{' ) ||
				(x == ')' && next == '[' ) )
			{
				return false;
			}
			t.push( "" + x );
		}
	}
	
	return true;
  }//end allMatched()
  
  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
