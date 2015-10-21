package parkingLot;

public class ParkingSpot {

	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;
	
	
	public ParkingSpot(Level lvl, int r, int n, VehicleSize s) {
		// TODO Auto-generated constructor stub
		this.level = lvl;
		this.row = r;
		this.spotNumber = n;
		this.spotSize = s;
	}

	public boolean isAvailable() {
			return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle v) {
		
	}
	
	public boolean park(Vehicle v) {
		
	}
	
	public int getRow() {
		return row;
	}
	
	public int getSpotNumber() {
		return spotNumber;
		
	}
	
	public void removeVehicle() {
		
	}
}
