// Frank Chen
// APCS2 pd2
// HW16 -- About Face
// 2018-03-07

public class Mysterion {
	
	// Swap Helper Method
	public void swap (int[] arr, int e1, int e2) {
		
		int temp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = temp;
		
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	*																   *
	*   This function marks the middle element before moving all other *
	*   elements smaller than it to the left, and those greater than   *
	*   it to the right. Order does not matter.        				   *
	*																   *
	*   	int a = the first element in the array                     *
	*       int b = the last element in the array                      *
	*       int c = the middle element in the array                    *
	*       int[] arr = the array being analyzed                       *
	*          														   *
	* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	// Mystery Algorithm
	public int sort (int a, int b, int c, int[] arr) {
		
		int v = arr[c];
		swap (arr, c, b);
		int s = a;
		
		for (int i = a; i <= b-1; i++) {
			if (arr[i] < v) {
				swap (arr, s, i);
				s += 1;
			}
		}
		
		swap (arr, b, s);
		return s;
	}
	
	
	// Main Method
	public static void main (String[] args) {
		
		Mysterion test = new Mysterion();
		int[] array = {7, 1, 5, 12, 3};
		
		System.out.println( test.sort (0, 4, 1, array ) ); // Should return 2
		
	}
	
}