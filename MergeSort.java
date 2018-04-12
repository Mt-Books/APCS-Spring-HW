/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
	The merge algorithm uses five if then statements which covers
	all possible scenarios between two lists. The sort algorithm
	uses 'merge' as a helper method. It first splits the array into
	two groups before applying merge on both of them.
  ======================================*/

// Frank Chen
// APCS2 pd2
// HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
// 2018-02-06
  
public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
	int total = (a.length + b.length);
	int countA = 0;
	int countB = 0;
	int[] merged = new int[total];
	
	for (int i = 0; i < total; i++) {
		if (countA == a.length) {
			merged[i] = b[countB];
			countB++;
		}
		else if (countB == b.length) {
			merged[i] = a[countA];
			countA++;
		}
		else if (a[countA] < b[countB]) {
			merged[i] = a[countA];
			countA++;
		}
		else if (b[countB] < a[countA]) {
			merged[i] = b[countB];
			countB++;
		}
		else if (a[countA] == b[countB]) {
			merged[i] = a[countA];
			i++;
			merged[i] = b[countB];
			countA++;
			countB++;
		}
	}
	return merged;
	
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
	int low = 1;
	int high = arr.length;
	int mid = (low + high) / 2;
	
	if (high == 1) {
		return arr;
	}
	else {
		int[] left = new int[mid];
		int[] right = new int[high - mid];
		
		for (int i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		for (int i = mid; i < high; i++) {
			right[i - mid] = arr[i];
		}
		
		return merge ( (sort(left)), (sort(right)) );
	}
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr2) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
	  
	  /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
