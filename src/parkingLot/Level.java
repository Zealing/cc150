package parkingLot;

public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;
	private static final int SPOTS_PER_ROW = 0;

	public Level(int flr, int numberSpots) {
		// TODO Auto-generated constructor stub
		this.floor = flr;
		spots = new ParkingSpot[numberSpots];
	}

	public int availableSpots() {
		return availableSpots;
	}
	
	public boolean parkVehicle(Vehicle v) {
		
	}
	
	private boolean parkStartingAtSpot(int num, Vehicle v) {
		
	}
	
	private int findAvailableSpots(Vehicle v) {
		
	}
	
	public void soptFreed() {
		availableSpots++;
	}
}
