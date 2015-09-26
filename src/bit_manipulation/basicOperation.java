package bit_manipulation;

public class basicOperation {

	//dtermine the bit number at ith position in a given number
	public static boolean getBit(int num, int i) {
		// TODO Auto-generated constructor stub
		return ( (num & (1 << i)) != 0);
	}
	
	public static int setBit(int num, int i) {
		return num | (1 << i);
	}
	
	public static int clearBit(int num, int i) {
		return num & (~(1 << i));
	}
	
	//clear all bits from i, inclusive
	public static int updateBit(int num, int i, int v) {
		int mask = (1 << i);
		return (num & mask) | (v << i);
	}

}
