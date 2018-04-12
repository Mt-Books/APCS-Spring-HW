/*
  Team Shiny 
  Brian Lin, Frank Chen 
  APCS2 pd2 
  HW07 -- A Man, A Plan, A Canal: Panama! 
  2018-02-13
*/

public class Resrever {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // Random string generator 
    public static String makeString (int length) {
	String str = "";
	for (int i = 0; i < length; i++) {
	    int randLetter = (int)(Math.random() * 26);
	    str = str + ALPHABET.substring(randLetter, randLetter + 1);
	}
	return str;
    }
    
    // O(n) time Algorithm
    public static String reverseStringLinear (String s) {
	if (s.length() <= 1) { // If the string is only 1 letter or no letters, return it
	    return s;
	}
	String result = ""; // The end product
	int counter = s.length(); // Length of the string
	while (counter > 0) { // Touches every char from the string from right to left and add to result
	    result += s.substring(counter - 1, counter);
	    counter -= 1;
	}
	return result;
    }
    
    // O(log2n) time Algorithm
    public static String reverseStringLog (String s) {
	if (s.length() <= 1) { // If the string is only 1 letter or no letters, return it
	    return s;
	}
	String leftPart = ""; // Split the string 
	String rightPart = ""; // into these 2 parts 
	int counterLeft = 0; // Left-Most index
	int counterRight = s.length(); // Right-Most Index 
	while (counterLeft != counterRight) {
	    leftPart += s.substring(counterRight-1, counterRight);
	    // The leftPart receives letters from String s from right to left. 
	   
	    String letter = s.substring(counterLeft, counterLeft+1);
	    letter += rightPart;
	    rightPart = letter;
	    // Since the addition of Strings prioritize what's to the left of the + sign, this is necessary.
	    // The rightPart expands from left to right but it takes the letter to the right and "places" it to the left
	    counterLeft++;
	    counterRight--;
	    if ( (counterRight == counterLeft + 1) && ( (s.length() % 2) == 1) ) {
		// If the length of the string is odd, there will be one letter where the counters are equal. Therefore,
		// add the letter to one of the Parts and then exit the loop
		leftPart += s.substring(counterRight-1, counterRight);
		break;
	    }
	    if ( (counterRight == counterLeft) && ((s.length() % 2) == 0) ) {
		// If the length of the string is even, then each Part will have the letters they need once the counters
		// are equal. Therefore, just exit the loop	
		break;
	    }
	}
	return leftPart + rightPart; // Add them together. Both of Parts are reversed versions of one-half of the String.
    }
    
    public static void main(String[] args) {
	System.out.println("================== Linear Test ==================\n");
	System.out.println("Original (Odd Length): " + "agree");
        System.out.println("Reversed: -->  " + reverseStringLinear("agree") + "\n"); // Should be eerga
	System.out.println("Original (Even Length): " + "apples");
	System.out.println("Reversed: -->  " + reverseStringLinear("apples") + "\n"); // Should be selppa
        String oppa = makeString(7);
        System.out.println("Original (Random Odd): " + oppa);
        System.out.println("Reversed: -->  " + reverseStringLinear(oppa) + "\n");
        System.out.println("================================================\n");

	System.out.println("================== Logarithmic Test ==================\n");
	System.out.println("Original (Odd Length): " + "titanic");
        System.out.println("Reversed: -->  " + reverseStringLinear("titanic") + "\n"); // Should be cinatit
	System.out.println("Original (Even Length): " + "ogre");
	System.out.println("Reversed: -->  " + reverseStringLinear("ogre") + "\n"); // Should be ergo
        String appo = makeString(10);
        System.out.println("Original (Random Even): " + appo);
        System.out.println("Reversed: -->  " + reverseStringLinear(appo) + "\n");
        System.out.println("========================================");

    }
}
