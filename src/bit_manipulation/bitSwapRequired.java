package bit_manipulation;

public class bitSwapRequired {

	public int bitSwapRequired(int a, int b) {
		// TODO Auto-generated constructor stub
		int count = 0;
		for (int c = a^b; c != 0; c >>= 1) {
			count += c & 1;
		}
		return count;
	}
	
	//a little bit better than former one---using fliping method to count bit number
	public int bitSwapRequiredImproved(int a, int b) {
		int count = 0;
		for (int c = a^b; c != 0; c = c & (c - 1)) {
			count++;
		}
		
		return count;
	}

}
