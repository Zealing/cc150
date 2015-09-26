package bit_manipulation;

public class swapOddEven {

	//it only works for 32-bit memory system in java--if do 64--similar
	public int swapOddEven(int n) {
		// TODO Auto-generated constructor stub
		return ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
	}

}
