package Elevator;

public class Elevator {

	public static Elevator instance = null;
	
	private int currentFloor;
	
	//?????
	public static Elevator Elevator() {
		if (instance == null) {
			synchronized (Elevator.class) {
				instance = new Elevator();
			}
		}
		return instance;
	}
	
	public Elevator() {
		// TODO Auto-generated constructor stub
	}

	public Elevator getInstance() {
		if (instance == null) {
			synchronized (SingletonDemo.class) {
				instance = new Elevator();
			}
		}
		return instance;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public void moveToTargetFloor(int toFloor) {
		currentFloor = toFloor;
	}
	
	public void moveUp() {
		
	}
	
	public void moveDown() {
		
	}
}
