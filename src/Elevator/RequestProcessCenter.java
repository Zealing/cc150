package Elevator;

import java.util.LinkedList;

public class RequestProcessCenter implements Runnable{

	public LinkedList<Request> queue;
	
	public RequestProcessCenter() {
		// TODO Auto-generated constructor stub
		queue = new LinkedList<Request>();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			processRequest();
		}
	}
	
	public void addRequest(Request request) {
		queue.add(request);
		
	}

	public void removeRequest(Request request) {
		queue.remove(request);
	}
	
	//do a for loop to find out the min distance request
	public Request getNextRequest() {
		Request shortestReq = null;
		int shortest = Integer.MAX_VALUE;
		int curFloor = Elevator.getInstance().getCurrentFloor();
		for (Request item: queue) {
			int distance = Math.abs(curFloor - item.getToFloor());
			if (distance < shortest) {
				shortest = distance;
				shortestReq = item;
			}
		}
		return shortestReq;
	}
	
	public void processRequest() {
		Request req = getNextRequest();
		if (req != null) {
			int toFloor = req.getToFloor();
			Elevator.getInstance().moveToTargetFloor(toFloor);
			queue.remove(req);
		}
	}
}
