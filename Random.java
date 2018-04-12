public class Random {
	
	public static void main (String[] args) {
		
		int[] array = {-1, -2, 1, 2};
		for (int x = 0; x <= 10; x++) {
			int rnd = (int)(Math.random() * array.length);
			System.out.println(array[rnd]);
		}
		
	}
	
}