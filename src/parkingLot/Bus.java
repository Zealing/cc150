package parkingLot;

public class Bus extends Vehicle {

	public Bus() {
		// TODO Auto-generated constructor stub
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}
	
	//check if the spot is large or not--don't check the num of spot it uses
	public boolean canFitInSpot(ParkingSpot spot) {
		
	}

}
