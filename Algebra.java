// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		int sum = x1;
		int ph = x2;
		if(x2 < 0)
			ph =  -(x2);
		for (int i = 0; i < ph; i++) {
			if( x2<0)
				sum--;
			else
				sum++;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int sum = x1;
		int ph = x2;
		if(x2 < 0)
			ph = -(x2);
		for (int i = 0; i < ph; i++) {
			if(x2 < 0)
				sum++;
			else
				sum--;
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int sum = 0;
		int ph = x2;
		if(x2 < 0)
			ph = -(x2);
		for (int i = 0; i < ph; i++) {
			if(x2 < 0)
				sum -= x1;
			else
				sum += x1;
		}
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int sum = 1;
		for (int i = 0; i < n; i++) {
			sum = times(sum, x);
		}
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		boolean isNeg1 = x1 < 0;
		boolean isNeg2 = x2 < 0;
		if(x2 > x1)
			return 0;
		if(x2 == x1)
			return 1;
		if(isNeg1)
			x1 = -(x1);
		if(isNeg2)
			x2 = -(x2);
		int count = 0;
		int res = 0;
		while(res < x1){
			res = plus(res, x2);
			if(res > x1)
				return count;
			count++;
		}
		if(isNeg1 ^ isNeg2)
			return -(count);
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		int x3 = div(x1, x2);
		return minus(x1, times(x2, x3));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int sqrt = 0;
		int pow = 0;
		while(pow < x){
			sqrt++;
			pow = pow(sqrt, 2);
			if(pow == x){
				return sqrt;
			}
		}
		if(pow > x)
			return sqrt-1;
		return sqrt;
	}	  	  
}
