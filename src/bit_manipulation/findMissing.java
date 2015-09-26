package bit_manipulation;

import java.util.ArrayList;

public class findMissing {

	public int findMissing(ArrayList<BitInteger> array) {
		// TODO Auto-generated constructor stub
		findMissing(array, 0);
	}
	
	//column is the position of bit we have to search at each time
	public int findMissing(ArrayList<BitInteger> input, int column) {
		if (column >= BitInteger.INTEGER_SIZE) {
			return 0;
		}
		
		ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input/2);
		ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(input/2);
		
		for (BitInteger t: input) {
			if (t.fetch(column) == 0) {
				zeroBits.add(t);
			}
			if (t.fetch(column) == 1) {
				oneBits.add(t);
			}
		}
		
		//if missing an even--1s will larger or equal to 0s
		if (zeroBits.size() <= oneBits.size()) {
			//recursively done the process
			int v = findMissing(zeroBits, column + 1);
			return (v << 1) | 0;
		} else {
			int v = findMissing(oneBits, column + 1);
			return (v << 1) | 1;
		}
	}

}
