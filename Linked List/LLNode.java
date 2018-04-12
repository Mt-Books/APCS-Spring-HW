/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

// Frank Chen
// APCS2 pd2
// HW21b -- We Got a Little Ol' Convoy...
// 2018-03-19

public class LLNode
{
    //instance vars
	private String cargo;
	private LLNode next;

    //constructor 
	public LLNode( String currentVal, LLNode nextVal ) 
	{
		cargo = currentVal;
		next = nextVal;
	}

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
		return cargo;
    }

    public LLNode getNext()
    {
		return next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo )
    {
		String oldCargo = getCargo();
		cargo = newCargo;
		return oldCargo;
    }

    public LLNode setNext( LLNode newNext )
    {
		LLNode oldNext = getNext();
		next = newNext;
		return oldNext;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
		String retStr = "Cargo: ";
		LLNode temp = next;
		while( temp != null )
		{
			retStr += temp.getCargo() + " ";
			temp = temp.getNext();
		}
		return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
		//PROTIP: try creating a few nodes: traversible, connected...
		//note anything notable as you develop and test...
		LLNode node = new LLNode( "you", null );
		node.setNext( new LLNode( "me", null ));
		node.getNext().setNext( new LLNode( "them", null ));
		LLNode temp = node;
		while( temp != null )
		{
			System.out.println( temp );
			temp = temp.getNext();
		}
    }//end main

}//end class LLNode
