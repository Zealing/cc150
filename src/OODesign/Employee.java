package OODesign;

import java.util.ArrayList;

public abstract class Employee {
	protected String id = null;
	protected int limit;
	
	protected ArrayList<Man> list;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public void addEmployee() {
		
	}
	
	public boolean isFull() {
		return false;
	}

	public void goWork(Man man) {
		man.goBusy();
	}
}
