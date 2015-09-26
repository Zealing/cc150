package mathandprob;

public class basicOperation {

	public int negate(int a) {
		int neg = 0;
		int d = a < 0? 1:-1;//if the numebr is negative -- give it positive and vice versa
		
		while (a != 0) {
			neg += d;
			a += d;
		}
		
		return neg;
	}
	
	public int subtraction (int a, int b) {
		return a + negate(b);
	}
	
	public int multiply (int a, int b) {
		if (a < b) {
			return multiply(b, a);
		}
		int sum = 0;
		for (int i = abs(b); i > 0 ; i--) {
			sum += a;
		}
		
		//remember to check the sign of b RATHER THAN a!!
		if (b < 0) {
			sum = negate(sum);
		}
		
		return sum;
	}
	
	private int abs(int a) {
		// TODO Auto-generated method stub
		if (a < 0) {
			return negate(a);
		} else {
			return a;
		}
	}

	//more complex that above
	public int division (int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Error divisor!");
		}
		
		//change division into multiplication
		int result = 0;
		int x = 0;
		//every time the product of x and b smaller than a---do addition and add x by 1
		//at the end, the x will be the factor, or the quotient 
		while (result + abs(b) < abs(a)) {
			result += abs(b);
			x++;
		}
		
		//check if have same sign to return different number
		if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
			return x;
		} else {
			return negate(x);
		}
	}
	
	public basicOperation() {
		// TODO Auto-generated constructor stub
	}

}
