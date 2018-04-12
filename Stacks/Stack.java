/*****************************************************
 * interface Stack
 * Specifies actions a stack must be able to perform.
 * Allows for generic typing.
 *****************************************************/

// Frank Chen
// APCS2 pd2
// HW32 - Leon Leonwood Stack
// 2018-04-11

public interface Stack<PANCAKE> 
{
    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty();

    //Return top element of stack without popping it.
    public PANCAKE peek();

    //Pop and return top element of stack.
    public PANCAKE pop();

    //Push an element onto top of this stack.
    public void	push( PANCAKE x );

}//end interface
