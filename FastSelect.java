// Frank Chen
// APCS2 pd2
// HW17 -- So So Fast
// 2018-03-10

public class FastSelect {	
	
	// Print Array Method
	public static void printArray ( int[] arr ) {
		
		String retstr = "[ ";
		
		for ( int i = 0; i < arr.length; i++ ) {
			retstr += arr[i] + " ";
		}
		
		retstr += "]";
		
		System.out.println ( retstr );
		
	}	
	
	// Swap Helper Method
	public static void swap ( int[] arr, int e1, int e2 ) {
		
		int temp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = temp;
		
	}
	
	// Partition Algorithm
	public static int partition ( int[] arr, int left, int right, int pvtPos ) {
		
		int pvtVal = arr[pvtPos];
		swap ( arr, pvtPos, right );
		int storPos = left;
		
		for ( int i = left; i <= right-1; i++ ) {
			if ( arr[i] < pvtVal ) {
				swap ( arr, storPos, i );
				storPos += 1;
			}
		}
		
		swap ( arr, right, storPos );
		printArray ( arr );
		
		return storPos;
		
	}
	
	// FastSelect Algorithm
	public static int fastSelect ( int[] arr, int yth ) {
		
		if ( yth <= 0 || yth > arr.length ) { // Invalid Inputs
			System.out.println ( yth + " is an invalid yth element" );
			System.exit(0);
		}
		
		int median = arr.length / 2; // Start from the middle element
	
		// Actual Method
		if ( yth > median ) {
			while ( median != arr.length ) {
				partition ( arr, 0, arr.length - 1, median );
				median++;
			}
		}
		else {
			while ( median != 0 ) {
				partition ( arr, 0, arr.length - 1, median );
				median--;
			}
		}
		
		// "Naive" Method
			// int counter = 0;
			
			// while ( counter != arr.length ) {
				// partition ( arr, 0, arr.length - 1, counter );
				// counter++;
			// }
		
		return arr[yth - 1];
		
	}
	
	// Main Method
	public static void main ( String[] args ) {
		
		System.out.println();
		
		int[] arrayOdd = { 15, 62, 79, 10, 33, 80, 24 };
		int[] arrayEven = { 42, 19, 30, 53, 68, 22 };
		
		printArray ( arrayOdd );
		System.out.println ( fastSelect ( arrayOdd, 1 ) ); // Should return 10
		System.out.println();
		
		printArray ( arrayEven );
		System.out.println ( fastSelect ( arrayEven, 6 ) ); // Should return 68
		System.out.println();
		
	}
	
}