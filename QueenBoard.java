/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */
 
 // Frank Chen
 // APCS2 pd2
 // HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Decaon] x n
 // 2018-02-27

public class QueenBoard
{
  private int[][] _board;
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
    return solveH(0); // Start from the first column
  }

  
  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
	if (col == _board.length) {
		return true; // Base case
	}
	for (int row = 0; row < _board.length; row++) {
		if (addQueen(row, col)) { // Check if possible to add a Queen
			addQueen(row, col);
			if (solveH(col + 1)) {
				return true; // Checks the next column
			}
			removeQueen(row, col); // Remove Queen if position is invalid
		}
	}
	return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
	String str = "";
	for (int row = 0; row < _board.length; row++) {
		for (int col = 0; col < _board[row].length; col++) {
			if (_board[row][col] == 1) {
				str += "Q";
			}
			else {
				str += "-";
			}
		}
		str += "\n";
	}
	System.out.println(str);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * <General description>
   * precondition: An existing board
   * postcondition: Adds a Queen to a valid position on the board
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
			_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
			_board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: An existing board
   * postcondition: Removes a Queen if its placement on the board is invalid
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
			_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
			_board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: N/A
   * postcondition: Overwrites default toString method
   */
  public String toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(8);
    b.solve();
	b.printSolution();
  }
    
}//end class
