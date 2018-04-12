/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

// Frank Chen
// APCS2 pd2
// HW32 - Leon Leonwood Stack
// 2018-04-11

public class Stckr
{
    public static void main( String[] args )
    {
		//Stack cakes = new ALStack(10);
		//Stack cakes = new LLStack<String>();

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

}//end class