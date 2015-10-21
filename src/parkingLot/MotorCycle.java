package parkingLot;

public class Motorcycle extends Vehicle {

	public Motorcycle() {
		// TODO Auto-generated constructor stub
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		// TODO Auto-generated method stub
		return false;
	}

}
