package stackandqueue;

public class threeStackFixed {

	int stackSize = 100;
	int[] arrayBuffer = new int[stackSize * 3];
	int[] stackPointer = {-1, -1, -1};
	
	public void push(int stackNum, int item) {
		if (stackPointer[stackNum] + 1 >= stackSize) {
			throw new ArrayIndexOutOfBoundsException("out of space");
		}
		
		stackPointer[stackNum]++;
		arrayBuffer[absTopOfStack(stackNum)] = item;
	}
	
	public int pop(int stackNum) {
		if (stackPointer[stackNum] == -1) {
			throw new IllegalArgumentException("pop an empty stack");
		}
		
		int result = arrayBuffer[absTopOfStack(stackNum)];
		
		arrayBuffer[absTopOfStack(stackNum)] = 0;
		stackPointer[stackNum]--;
		
		return result;
	}
	
	public int peek(int stackNum) {
		return arrayBuffer[absTopOfStack(stackNum)];
	}
	
	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}
	
	//using this method to get the top of each stack---much more convenient than if-else command
	public int absTopOfStack (int stackNum) {
		return stackNum * stackSize + stackPointer[stackNum];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
