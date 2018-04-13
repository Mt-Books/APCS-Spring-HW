/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Find the innermost pair of open/close parens and
 *      its operation and numbers.
 *   2. Modify the expression so that it can be used as
 *      parameters by the unload method.
 *	 3. The unload method solves the given expression and
 *      returns a value to replace the original expression.
 *	 4. Repeat steps 1 to 3 until there's a single term left
 *      in the expression.
 *   5. Return that term.
 *
 * STACK OF CHOICE: LLStack by my HW32
 * b/c ... both LLStack and ALStack have similar coding
 *         so I just chose one of them at random...
 ******************************************************/

// Frank Chen
// APCS2 pd2
// HW33 -- What a Racket
// 2018-04-12

public class Scheme
{
	LLStack<String> _stack = new LLStack<String>();
	
  /****************************************************** 
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and 
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr ) 
  {
	  String[] array = expr.split( "\\s+" );
	  int start = 0, end = 0;
	  
	  if( ! expr.substring( 0,1 ).equals( "(" ) )
	  {
		  return expr; // Stops if first character is not an open paren.
	  }
	  for( int i = 0; i < expr.length(); i++ )
	  {
		  if( expr.substring( i, i + 1 ).equals( "(" ) )
		  {
			  start = i; // Sets location of first open paren.
		  }
		  if( expr.substring( i, i + 1 ).equals( ")" ) )
		  {
			  end = i; // Sets location of first closing paren.
			  break;
		  }
	  }
	  
	  String op = expr.substring( start, end + 1 );
	  int operand = 0; 
	  
	  if( op.substring( 2, 3 ).equals( "+" ) )
	  {
		  operand = 1;
	  }
	  if( op.substring( 2, 3 ).equals( "-" ) )
	  {
		  operand = 2;
	  }
	  if( op.substring( 2, 3 ).equals( "*" ) )
	  {
		  operand = 3;
	  }
	  
	  op = op.substring( 4, op.length() - 2 );
	  String[] stack = op.split("\\s+");
	  LLStack<String> stackArr = new LLStack<String>();
	  
	  for( String a : stack )
	  {
		  stackArr.push( a );
	  }
	  
	  String ret = unload( operand, stackArr );
	  expr = expr.substring( 0, start ) + ret + expr.substring( end + 1 );
	  return evaluate( expr );
	  
  }//end evaluate()


  /****************************************************** 
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers ) 
  {
	  LLStack<String> temp = new LLStack<String>();
	  
	  while( numbers.isEmpty() == false )
	  {
		  temp.push( numbers.pop() );
	  }
	  
	  numbers = temp;
	  int result = 0;
	  if( op == 1 )
	  {
		  result = 0;
		  while( numbers.isEmpty() == false )
		  {
			  result += Integer.parseInt( numbers.pop() );
		  }
	  }
	  if( op == 2 )
	  {
		  result = Integer.parseInt( numbers.pop() );
		  while( numbers.isEmpty() == false )
		  {
			  result -= Integer.parseInt( numbers.pop() );
		  }
	  }
	  if( op == 3 )
	  {
		  result = 1;
		  while( numbers.isEmpty() == false )
		  {
			  result *= Integer.parseInt( numbers.pop() );
		  }
	  }
	  return Integer.toString( result );
	  
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }
  */


  //main method for testing
  public static void main( String[] args )
  {
	  System.out.println();
      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) + "\n" );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) + "\n" );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) + "\n" );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
	  /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
