package mathandprob;

public class SieveofEraPrime {

	public boolean[] sieveOfEraPrime (int max) {
		boolean[] flags = new boolean[max + 1];
		int cnt = 0;
		
		init(flags);
		int prime = 2;
		
		while (prime <= Math.sqrt(max)) {
			crossOff(flags, prime);
			
			prime = getNextPrime(flags, prime);
			
			if (prime >= flags.length) {
				break;
			}
		}
		
		return flags;
	}
	
	private void init(boolean[] flags) {
		// TODO Auto-generated method stub
		for (int i = 0; i < flags.length; i++) {
			flags[i] = true;
		}
	}

	public void crossOff(boolean[] flags, int prime) {
		for (int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}
	
	public int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while (next < flags.length && !flags[next]) {
			next++;
		}
		
		return next;
	}
	
	public void SieveofEra() {
		// TODO Auto-generated constructor stub
	}

}
