package bit_manipulation;

public class sameBit {

	public int getNext(int n) {
		//compute c0 and c1
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		//error chekc: when number is 11..1100..00, there is no bigger number!
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		
		//main process
		int p = c1 + c0; //right-most non-trailing 0
		
		n |= (1 << p);//flip that bit
		n &= ~((1 << p) - 1); //clear all bits right of that bit
		n |= (1 << (c1 - 1)) - 1; //set c1 - 1 ones to the right of the number
		
		return n;
	}
	
	public int getPre(int n) {
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}
		
		//error check--if no 1 before 0--means no same 1 bits smaller than that number!
		if (temp == 0) return -1;
		
		while (((temp & 1) == 0) && (temp != 0) ) {
			c0++;
			temp >>= 1;
		}
		
		//main process
		//first, flip that bit to 0 and clear all bits right of that bit
		int p = c0 + c1;
		n &= ((~0) << (p + 1));
		
		//second, add c1 + 1 ones to the right position of that bit
		int mask = (1 << (c1 + 1)) - 1; //have to minus 1--to get the next smaller number of 100..00 which is 11..11
		n |= (mask << (c0 - 1)); //have to minus 1--to get the immediate right place of that bit
		
		return n;
	}
	
	public sameBit() {
		// TODO Auto-generated constructor stub
	}

}
